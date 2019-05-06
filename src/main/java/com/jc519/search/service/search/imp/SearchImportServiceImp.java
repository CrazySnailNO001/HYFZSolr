package com.jc519.search.service.search.imp;

import com.jc519.search.dao.SearchJcMedicineResultMapper;
import com.jc519.search.model.AllControlMedicineResult;
import com.jc519.search.model.SearchJcMedicineResult;
import com.jc519.search.model.generator.MedicineAuthorization;
import com.jc519.search.service.search.SearchImportService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 导入数据
 *
 * @author Administrator
 */
@Service
public class SearchImportServiceImp implements SearchImportService {

    private final Logger logger = LoggerFactory.getLogger(SearchImportServiceImp.class);

    @Autowired
    private SearchJcMedicineResultMapper searchJcMedicineResultMapper;

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private SolrClient hotSolrClien;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${spring.data.solr.collection.noControlMedicineGoods}")
    private String solrNoControlMedicineGoods;

    @Value("${spring.data.solr.collection.controlMedicineGoods}")
    private String solrControlMedicineGoods;

    @Value("${spring.data.solr.collection.hotWords}")
    private String solrHotWords;

    @Override
    public String importData() throws Exception {
        // 集採的商品
        importNoControlMedicineGoods();
        // 控销的商品
        importControlMedicineGoods();
        return "导入成功";
    }

    /**
     * 定时更新索引库
     */
    public String updateIndex() throws Exception {
        //获取上次更新索引库的时间
        ValueOperations ops = redisTemplate.opsForValue();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastIndexTime = (String) ops.get("lastIndexTime");
        if (lastIndexTime == null) {
            lastIndexTime = form.format(new Date());
        }

        Map param = new HashMap<String, String>();
        param.put("lastIndexTime", lastIndexTime);
        updateControlMedicineGoods(param);
        updateNoControlMedicineGoods(param);
        updateHotWords(param);

        //添加这次的更新时间
        String lastIndexTime0 = form.format(new Date());
        ops.set("lastIndexTime", lastIndexTime0);
        return "更新完成";

    }

    /**
     * 更新控销的商品索引
     *
     * @param param
     * @throws Exception
     */
    private void updateControlMedicineGoods(Map param) throws Exception {
        //先查询所有更新的数据,再根据medicineID删除索引,再添加新的索引
        solrClient = new HttpSolrClient(solrControlMedicineGoods);
        List<Integer> updateControlIds = searchJcMedicineResultMapper.getUpdateControlIds(param);
        for (Integer medicineId : updateControlIds) {
            solrClient.deleteByQuery("(medicineGoodsId:" + medicineId + ")");
            param = new HashMap();
            param.put("id", medicineId);
            List<SearchJcMedicineResult> goods = searchJcMedicineResultMapper.getUpdaControlGoods(param);
            if (null != goods && 0 != goods.size()) {
                SearchJcMedicineResult searchJcMedicineResult = goods.get(0);
                SolrInputDocument document = createMedicineGoodsDocument(searchJcMedicineResult);
                document.addField("authId", new Integer(0));
                solrClient.add(document); // 向索引库中添加商品
                addControlIndex(searchJcMedicineResult);
            }
        }

        solrClient.commit();
        solrClient.close();
    }

    /**
     * 更新集采商品索引
     *
     * @param param
     * @throws Exception
     */
    private void updateNoControlMedicineGoods(Map param) throws Exception {
        //先查询所有更新的数据,再根据medicineID删除索引,再添加新的索引
        solrClient = new HttpSolrClient(solrNoControlMedicineGoods);
        List<Integer> updateNoControlIds = searchJcMedicineResultMapper.getUpdateNoControlIds(param);
        for (Integer id : updateNoControlIds) {
            solrClient.deleteByQuery("(medicineGoodsId:" + id + ")");
        }
        List<SearchJcMedicineResult> searchJcMedicineResults = searchJcMedicineResultMapper.getNoControlGoods(param);
        for (SearchJcMedicineResult searchJcMedicineResult : searchJcMedicineResults) {
            SolrInputDocument document = createMedicineGoodsDocument(searchJcMedicineResult);
            solrClient.add(document);
        }

        solrClient.commit();
        solrClient.close();
    }

    /**
     * 根据商品id删除索引
     *
     * @param solrClient
     * @param medicineId
     */
    private void deleteIndex(SolrClient solrClient, Integer medicineId) throws Exception {
        SolrQuery query = new SolrQuery();
        ModifiableSolrParams params = new ModifiableSolrParams();
        query.setQuery("(medicineGoodsId:" + medicineId + ")");

        params.add(query);
        QueryResponse response = solrClient.query(params);
        SolrDocumentList results = response.getResults();
        if (null != results && results.size() != 0) {
            for (SolrDocument solrDocument : results) {
                String id = solrDocument.get("id").toString();
                solrClient.deleteById(id);
            }
        }
    }

    /**
     * 更新搜索热词索引
     *
     * @param param
     * @throws Exception
     */
    private void updateHotWords(Map param) throws Exception {
        solrClient = new HttpSolrClient(solrHotWords);

        List<String> deleteNames = new ArrayList<>();

        List<String> controlDeleteNames = searchJcMedicineResultMapper.getControlDeleteNames(param);

        List<String> noControlDeleteNames = searchJcMedicineResultMapper.getNoControlDeleteNames(param);

        deleteNames.addAll(controlDeleteNames);
        deleteNames.addAll(noControlDeleteNames);
        HashSet h = new HashSet(deleteNames);
        deleteNames.clear();
        deleteNames.addAll(h);

        List<String> addNames = searchJcMedicineResultMapper.getAddNames(param);

        if (deleteNames.size() != 0) {
            solrClient.deleteById(deleteNames);
        }
        hotSolrClien = new HttpSolrClient(solrHotWords);
        for (String genericName : addNames) {
            //查询索引库,看索引库是否有这个genericName

            SolrQuery query1 = new SolrQuery();
            query1.setQuery("(genericName:" + genericName + ")");
            ModifiableSolrParams params2 = new ModifiableSolrParams();
            params2.add(query1);
            QueryResponse response = hotSolrClien.query(params2);
            SolrDocumentList results = response.getResults();
            if (null != results && results.size() != 0) {
                String frequencys = results.get(0).get("frequency").toString();
                Integer frequency = Integer.parseInt(frequencys) + 1;
                HashMap<String, Object> oper = new HashMap<>();
                oper.put("set", frequency);
                SolrInputDocument inputDocument = new SolrInputDocument();
                inputDocument.addField("genericName", results.get(0).get("genericName").toString());
                inputDocument.addField("frequency", frequency);
                hotSolrClien.add(inputDocument);
            } else {
                SolrInputDocument document = new SolrInputDocument();
                document.addField("genericName", genericName);
                document.addField("frequency", "0");
                solrClient.add(document);
            }
            hotSolrClien.commit();

        }
        hotSolrClien.close();
        solrClient.commit();
        solrClient.close();
    }

    /**
     * 全量导入集采商品
     *
     * @throws Exception
     */
    private void importNoControlMedicineGoods() throws Exception {
        solrClient = new HttpSolrClient(solrNoControlMedicineGoods);
        // 查询所有集採商品数据。
        Map param = new HashMap();
        param.put("belongColumn", "1");
        List<SearchJcMedicineResult> jcMedicineResultList = searchJcMedicineResultMapper.selectJcMedicineResult(param);
        // 为每个商品创建一个SolrInputDocument对象。
        for (SearchJcMedicineResult searchJcMedicineResult : jcMedicineResultList) {
            SolrInputDocument document = createMedicineGoodsDocument(searchJcMedicineResult);
            solrClient.add(document); // 向索引库中添加商品
        }
        // 提交修改
        solrClient.commit();
        solrClient.close();
    }

    /**
     * 全量导入控销商品
     */
    private void importControlMedicineGoods() throws Exception {
        solrClient = new HttpSolrClient(solrControlMedicineGoods);
        hotSolrClien = new HttpSolrClient(solrHotWords);

        /*new*/
        List<AllControlMedicineResult> controlMedicineResults = searchJcMedicineResultMapper.selectAllControlMedicine();




/*
        // 查询所有控销商品数据。
        Map param = new HashMap();
        param.put("belongColumn", "2");
        List<SearchJcMedicineResult> jcMedicineResultList = searchJcMedicineResultMapper.selectJcMedicineResult(param);
        // 为每个商品创建一个SolrInputDocument对象。
        for (SearchJcMedicineResult searchJcMedicineResult : jcMedicineResultList) {
            //判断该商品对应的产品是否全部下架
            if (null != searchJcMedicineResult.getMedicineProductId()) {
                param = new HashMap<String, String>();
                param.put("medicineProductId", searchJcMedicineResult.getMedicineProductId().toString());
                List<Integer> exitProduct = searchJcMedicineResultMapper.getExitProduct(param);
                if (exitProduct != null && exitProduct.size() != 0) {
                    SolrInputDocument document = createMedicineGoodsDocument(searchJcMedicineResult);
                    document.addField("authId", new Integer(0));
                    solrClient.add(document); // 向索引库中添加商品

                    addControlIndex(searchJcMedicineResult);

                    //添加搜索热词的索引库
                    SolrInputDocument suggestDocument = createHotWordsDocument(searchJcMedicineResult);
                    hotSolrClien.add(suggestDocument);
                }
            }

        }*/
        // 提交修改
        solrClient.commit();
        solrClient.close();
        hotSolrClien.commit();
        hotSolrClien.close();
    }

    private void addControlIndex(SearchJcMedicineResult searchJcMedicineResult) throws SolrServerException, IOException {
        Map param;
        if (searchJcMedicineResult.getMedicineProductId() != null) {
            param = new HashMap<String, String>();
            if (null != searchJcMedicineResult.getCompanyId().toString())
                param.put("companyId", searchJcMedicineResult.getCompanyId());
            if (null != searchJcMedicineResult.getMedicineProductId())
                param.put("medicineProductId", searchJcMedicineResult.getMedicineProductId().toString());
            List<MedicineAuthorization> medicineAuthorizationList = searchJcMedicineResultMapper.selectDivisionMedicineAuthorizationList(param);

            logger.debug("create medicineGoods index id:" + searchJcMedicineResult.getId());
            if (medicineAuthorizationList != null && 0 != medicineAuthorizationList.size()) {
                for (MedicineAuthorization medicineAuthorization : medicineAuthorizationList) {
                    SolrInputDocument childDocument = createMedicineGoodsDocument(searchJcMedicineResult);
                    childDocument = createMedicineAuthorizationDocument(childDocument, medicineAuthorization);
                    solrClient.add(childDocument); // 向索引库中添加授权商品
                }
            }
        }
    }

    /**
     * 添加搜索热词的索引库
     *
     * @param searchJcMedicineResult
     * @return
     */
    private SolrInputDocument createHotWordsDocument(SearchJcMedicineResult searchJcMedicineResult) {
        SolrInputDocument document = new SolrInputDocument();
        // 为文档添加域
        if (searchJcMedicineResult.getGenericName() != null) {
            document.addField("genericName", searchJcMedicineResult.getGenericName());
            document.addField("frequency", "0");
        }
        return document;
    }

    /**
     * 添加商品普通属性索引
     *
     * @param searchJcMedicineResult
     * @return
     */
    private SolrInputDocument createMedicineGoodsDocument(SearchJcMedicineResult searchJcMedicineResult) {
        SolrInputDocument document = new SolrInputDocument();
        // 为文档添加域
        document.addField("medicineGoodsId", searchJcMedicineResult.getId());
        if (searchJcMedicineResult.getMedicineProductId() != null) {
            document.addField("medicineProductId", searchJcMedicineResult.getMedicineProductId());
        }
        if (searchJcMedicineResult.getGenericName() != null) {
            document.addField("genericName", searchJcMedicineResult.getGenericName());
            document.addField("genericName2", searchJcMedicineResult.getGenericName());
        }
        if (searchJcMedicineResult.getTradeName() != null) {
            document.addField("tradeName", searchJcMedicineResult.getTradeName());
            document.addField("tradeName2", searchJcMedicineResult.getTradeName());
        }
        if (searchJcMedicineResult.getImgUrl() != null) {
            document.addField("imgUrl", searchJcMedicineResult.getImgUrl());
        }
        if (searchJcMedicineResult.getSpecification() != null) {
            document.addField("specification", searchJcMedicineResult.getSpecification());
        }
        if (searchJcMedicineResult.getCategoryId() != null) {
            document.addField("cateId", searchJcMedicineResult.getCategoryId());
        }
        if (searchJcMedicineResult.getCateSecondId() != null) {
            document.addField("cateSecondId", searchJcMedicineResult.getCateSecondId());
        }
        if (searchJcMedicineResult.getCateThirdId() != null) {
            document.addField("cateThirdId", searchJcMedicineResult.getCateThirdId());
        }
        if (searchJcMedicineResult.getGenericCateId() != null) {
            document.addField("genericCateId", searchJcMedicineResult.getGenericCateId());
        }
        if (searchJcMedicineResult.getGenericCateSecondId() != null) {
            document.addField("genericCateSecondId", searchJcMedicineResult.getGenericCateSecondId());
        }
        if (searchJcMedicineResult.getDosageFormId() != null) {
            document.addField("dosageFormId", searchJcMedicineResult.getDosageFormId());
        }
        if (searchJcMedicineResult.getDosageFormName() != null) {
            document.addField("dosageFormName", searchJcMedicineResult.getDosageFormName());
        }
        if (searchJcMedicineResult.getReimbursementType() != null) {
            document.addField("reimbursementType", searchJcMedicineResult.getReimbursementType());
        }
        if (searchJcMedicineResult.getBasicOrCommon() != null) {
            document.addField("basicOrCommon", searchJcMedicineResult.getBasicOrCommon());
        }
        if (searchJcMedicineResult.getProduceEnterprice() != null) {
            document.addField("produceEnterprice", searchJcMedicineResult.getProduceEnterprice());
        }
        if (searchJcMedicineResult.getApprovalNum() != null) {
            document.addField("approvalNum", searchJcMedicineResult.getApprovalNum());
        }
        if (searchJcMedicineResult.getBoxNum() != null) {
            document.addField("boxNum", searchJcMedicineResult.getBoxNum());
        }
        if (searchJcMedicineResult.getUnitId() != null) {
            document.addField("unitId", searchJcMedicineResult.getUnitId());
        }
        if (searchJcMedicineResult.getUnitName() != null) {
            document.addField("unitName", searchJcMedicineResult.getUnitName());
        }
        if (searchJcMedicineResult.getCompanyId() != null) {
            document.addField("companyId", searchJcMedicineResult.getCompanyId());
        }
        if (searchJcMedicineResult.getCompanyName() != null) {
            document.addField("companyName", searchJcMedicineResult.getCompanyName());
        }
        if (searchJcMedicineResult.getSuggestedPrice() != null) {
            document.addField("suggestedPrice", searchJcMedicineResult.getSuggestedPrice().floatValue());
        }
        if (searchJcMedicineResult.getAvailabilityPrice() != null) {
            document.addField("availabilityPrice", searchJcMedicineResult.getAvailabilityPrice().floatValue());
        }
        return document;
    }

    /**
     * 添加控销商品控销属性索引
     *
     * @param document
     * @param medicineAuthorization
     * @return
     */
    private SolrInputDocument createMedicineAuthorizationDocument(SolrInputDocument document, MedicineAuthorization medicineAuthorization) {
        document.addField("authId", medicineAuthorization.getAuthId());
        logger.debug("create medicineAuthPrice index id:" + medicineAuthorization.getAuthId());
        if (medicineAuthorization.getCompanyId() != null) {
            document.addField("authCompanyId", medicineAuthorization.getCompanyId());
        }
        if (medicineAuthorization.getControlChannelId() != null) {
            document.addField("authControlChannelId", medicineAuthorization.getControlChannelId());
        }
        if (medicineAuthorization.getAuControlCompanyId() != null) {
            document.addField("authControlCompanyId", medicineAuthorization.getAuControlCompanyId());
        }
        if (medicineAuthorization.getDivisionMedicineId() != null) {
            document.addField("authDivisionMedicineId", medicineAuthorization.getDivisionMedicineId());
        }
        if (medicineAuthorization.getAuthorizationPrice() != null) {
            document.addField("authorizationPrice", medicineAuthorization.getAuthorizationPrice().floatValue());
        }
        return document;
    }
}
