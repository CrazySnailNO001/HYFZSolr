package com.jc519.search.service.search.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jc519.common.contantenum.*;
import com.jc519.common.errorcode.ErrorCodeEnum;
import com.jc519.common.errorcode.MedicineErrorCodeEnum;
import com.jc519.common.model.JcSimplyCompany;
import com.jc519.common.security.token.JcUserDetails;
import com.jc519.common.security.token.JcUserFactory;
import com.jc519.common.util.LikeValueFactory;
import com.jc519.common.web.rest.errors.CustomServiceException;
import com.jc519.search.dao.JcDivisionMedicineAdviceMapper;
import com.jc519.search.dao.SearchJcMedicineResultMapper;
import com.jc519.search.dao.generator.JcDivisionCompanyMapper;
import com.jc519.search.dao.generator.JcUserCompanyMapper;
import com.jc519.search.model.CpMedicineExample;
import com.jc519.search.service.search.SearchService;
import com.jc519.search.web.rest.search.param.CpMedicineGoodsFilterParam;
import com.jc519.search.web.rest.search.param.KeywordSuggestParam;
import com.jc519.search.web.rest.search.param.PageParam;
import com.jc519.search.web.rest.search.param.SearchMedicineGoodsParam;
import com.jc519.search.web.rest.search.result.CpMedicineGoodsResult;
import com.jc519.search.web.rest.search.result.KeywordSuggestResult;
import com.jc519.search.web.rest.search.result.SearchMedicineGoodsResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.*;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.GroupParams;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 过滤查询Service
 *
 * @author Administrator
 */
@Service
public class SearchServiceImp implements SearchService {

    private final Logger logger = LoggerFactory.getLogger(SearchServiceImp.class);

    @Autowired
    private SearchJcMedicineResultMapper searchJcMedicineResultMapper;
    @Autowired
    private JcDivisionMedicineAdviceMapper divisionMedicineAdviceMapper;

    @Autowired
    private JcDivisionCompanyMapper divisionCompanyMapper;

    @Autowired
    private JcUserCompanyMapper userCompanyMapper;
    @Autowired
    private SolrClient solrClient;
    @Autowired
    private SolrClient solrClient2;
    @Autowired
    private SolrClient updateSolrClient;

    @Autowired
    private SolrClient hotSolrClien;

    @Value("${spring.data.solr.collection.noControlMedicineGoods}")
    private String solrNoControlMedicineGoods;

    @Value("${spring.data.solr.collection.controlMedicineGoods}")
    private String solrControlMedicineGoods;

    @Value("${spring.data.solr.collection.hotWords}")
    private String solrHotWords;

    private final static Integer SEARCH_START = 0;
    private final static Integer HOT_PAGESIZE = 5;
    private final static Integer SUGGEST_PAGE_SIZE = 20;

    /**
     * 搜索热词接口
     * @return
     */
    @Override
    public List<String> searchHotWords() {
        List<String> list = new ArrayList<>();
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setSort("frequency", ORDER.desc);
        query.setStart(SEARCH_START);
        query.setRows(HOT_PAGESIZE);
        hotSolrClien = new HttpSolrClient(solrHotWords);
        try {
            QueryResponse queryResponse = hotSolrClien.query(query);

            SolrDocumentList results = queryResponse.getResults();
            if (null != results && results.size() != 0) {
                for (SolrDocument solrDocument : results) {
                    list.add(solrDocument.get("genericName").toString());
                }
            }

        } catch (SolrServerException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        } catch (IOException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        }
        return list;
    }


    /**
     * 搜索商品列表
     *
     * @param searchMedicineGoodsParam
     * @return
     */
    @Override
    public PageInfo<SearchMedicineGoodsResult> searchMedicineGoods(SearchMedicineGoodsParam searchMedicineGoodsParam) {
        JcUserDetails userDetails = JcUserFactory.getJcUserDetails();
        SolrQuery query = new SolrQuery();
        ModifiableSolrParams params = new ModifiableSolrParams();
        String keyword = searchMedicineGoodsParam.getKeyword();
        Integer isControl = searchMedicineGoodsParam.getIsControl();
        boolean isLogin = userDetails == null ? false : true;
        isControl = isControl == null ? 0 : isControl;
        String queryStr = "";
        if (StringUtils.isBlank(keyword)) {
            keyword = "*";
            if (null != searchMedicineGoodsParam.getType() && searchMedicineGoodsParam.getType() == 1) { //1代表PC端 2代表APP端,默认APP端
                queryStr = "(genericName:" + keyword + " OR tradeName:" + keyword + " OR produceEnterprice:" + keyword + ")";
            } else {
                queryStr = "(genericName:" + keyword + " OR tradeName:" + keyword + ")";
            }
        } else {
            if (null != searchMedicineGoodsParam.getType() && searchMedicineGoodsParam.getType() == 1) { //1代表PC端 2代表APP端,默认APP端
                queryStr = "(genericName:\"" + keyword + "\" OR tradeName:\"" + keyword + "\" OR produceEnterprice:\"" + keyword + "\")";
            } else {
                queryStr = "(genericName:\"" + keyword + "\" OR tradeName:\"" + keyword + "\")";
            }

            //查询索引库,看索引库是否有这个key
            hotSolrClien = new HttpSolrClient(solrHotWords);
            SolrQuery query1 = new SolrQuery();
            query1.setQuery("(genericName:" + keyword + ")");
            try {
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
                }
                hotSolrClien.commit();
                hotSolrClien.close();
            } catch (SolrServerException e) {
                throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
            } catch (IOException e) {
                throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
            }
        }

        //商品分类只会传一个过来
        if (searchMedicineGoodsParam.getCateThirdId() != null) {
            queryStr += " AND cateThirdId:" + searchMedicineGoodsParam.getCateThirdId();
        } else if (searchMedicineGoodsParam.getCateSecondId() != null) {
            queryStr += " AND cateSecondId:" + searchMedicineGoodsParam.getCateSecondId();
        } else if (searchMedicineGoodsParam.getCategoryId() != null) {
            queryStr += " AND cateId:" + searchMedicineGoodsParam.getCategoryId();
        }
        if (null != searchMedicineGoodsParam.getGenericCateSecondId()) {
            queryStr += " AND genericCateSecondId:" + searchMedicineGoodsParam.getGenericCateSecondId();
        } else if (null != searchMedicineGoodsParam.getGenericCateId()) {
            queryStr += " AND genericCateId:" + searchMedicineGoodsParam.getGenericCateId();
        }
        if (searchMedicineGoodsParam.getDosageFormId() != null) {
            queryStr += " AND dosageFormId:" + searchMedicineGoodsParam.getDosageFormId();
        }
        if (searchMedicineGoodsParam.getReimbursementType() != null) {
            queryStr += " AND reimbursementType:" + searchMedicineGoodsParam.getReimbursementType();
        }
        if (searchMedicineGoodsParam.getBasicOrCommon() != null) {
            queryStr += " AND basicOrCommon:" + searchMedicineGoodsParam.getBasicOrCommon();
        }
        if (isControl != null && isControl == 1) {      //默认控销商品
            solrClient = new HttpSolrClient(solrNoControlMedicineGoods);
        } else {
            solrClient = new HttpSolrClient(solrControlMedicineGoods);
            if (isLogin) {
                //取用户的公司
                Integer buyCompanyId = (userDetails.getCompanyList() != null && userDetails.getCompanyList().size() > 0) ? userDetails.getCompanyList().get(0).getCompanyId() : 0;
                queryStr += " AND (authId:0 OR authControlCompanyId:" + buyCompanyId + ")";
                query.set(GroupParams.GROUP, true);
                query.set(GroupParams.GROUP_FIELD, "medicineGoodsId");
                query.set(GroupParams.GROUP_LIMIT, "1"); // 默认为1
                query.set(GroupParams.GROUP_SORT, "authId desc");
                query.set(GroupParams.GROUP_TOTAL_COUNT, "true");
                query.setSort("authId", ORDER.desc);
            } else {
                queryStr += " AND (authId:0)";
            }
        }
        query.setQuery(queryStr);
        int pageNum = searchMedicineGoodsParam.getPageNum();
        int pageSize = searchMedicineGoodsParam.getPageSize();
        pageNum = pageNum < 1 ? 1 : pageNum;
        int start = (pageNum - 1) * pageSize;
        query.setStart(start);
        query.setRows(searchMedicineGoodsParam.getPageSize());
        PageInfo<SearchMedicineGoodsResult> searchMedicineGoodsResultPageInfo = dealMedicineGoods(params, query, isLogin, isControl);

        //设置分页数据
        setPageInfo(searchMedicineGoodsParam, pageNum, pageSize, searchMedicineGoodsResultPageInfo);

        return searchMedicineGoodsResultPageInfo;
    }

    private void setPageInfo(SearchMedicineGoodsParam searchMedicineGoodsParam, int pageNum, int pageSize, PageInfo<SearchMedicineGoodsResult> searchMedicineGoodsResultPageInfo) {
        searchMedicineGoodsResultPageInfo.setPageNum(searchMedicineGoodsParam.getPageNum());
        searchMedicineGoodsResultPageInfo.setPageSize(pageSize);
        Long total = searchMedicineGoodsResultPageInfo.getTotal();
        int pages = (int) Math.ceil(total / pageSize);
        if (total % pageSize > 0) {
            pages++;
        }
        int[] navigatepageNums = new int[pages];
        for (int i = 0; i < pages; i++) {
            navigatepageNums[i] = i + 1;
        }
        searchMedicineGoodsResultPageInfo.setNavigatepageNums(navigatepageNums);
        searchMedicineGoodsResultPageInfo.setPages(pages);
        searchMedicineGoodsResultPageInfo.setStartRow((pageNum - 1) * pageSize);
        if (pages == pageNum) {
            searchMedicineGoodsResultPageInfo.setIsLastPage(true);
        } else {
            searchMedicineGoodsResultPageInfo.setIsLastPage(false);
        }
        if (pages - pageNum > 0) {
            searchMedicineGoodsResultPageInfo.setNextPage(pageNum + 1);
            searchMedicineGoodsResultPageInfo.setHasNextPage(true);
        } else {
            searchMedicineGoodsResultPageInfo.setNextPage(pageNum);
            searchMedicineGoodsResultPageInfo.setHasNextPage(false);
        }
        searchMedicineGoodsResultPageInfo.setNavigatePages(pages);
        searchMedicineGoodsResultPageInfo.setNavigatepageNums(navigatepageNums);
        searchMedicineGoodsResultPageInfo.setNavigateFirstPage(pageNum);
        searchMedicineGoodsResultPageInfo.setNavigateLastPage(navigatepageNums.length);
    }


    private PageInfo<SearchMedicineGoodsResult> dealMedicineGoods(ModifiableSolrParams params, SolrQuery query, boolean isLogin, Integer isControl) {

        try {
            List<SearchMedicineGoodsResult> searchMedicineGoodsResultList = new ArrayList<>();
            long total = 0;

            params.add(query);
            QueryResponse queryResponse = solrClient.query(params);
            if (queryResponse != null) {
                GroupResponse groupResponse = queryResponse.getGroupResponse();
                if (groupResponse != null) {
                    List<GroupCommand> groupList = groupResponse.getValues();
                    for (GroupCommand groupCommand : groupList) {
                        List<Group> groups = groupCommand.getValues();
                        for (Group group : groups) {
                            SolrDocumentList solrDocumentList = group.getResult();
                            for (SolrDocument solrDocument : solrDocumentList) {
                                searchMedicineGoodsResultList.add(dealMedicineGoods(solrDocument, isLogin, isControl));
                            }
                        }
                        total = groupCommand.getNGroups();
                    }
                } else {
                    SolrDocumentList solrDocumentList = queryResponse.getResults();
                    if (solrDocumentList != null && solrDocumentList.size() != 0) {
                        for (SolrDocument solrDocument : solrDocumentList) {
                            searchMedicineGoodsResultList.add(dealMedicineGoods(solrDocument, isLogin, isControl));
                        }
                        total = solrDocumentList.getNumFound();
                    }
                }
                logger.debug("num found:" + total + " list size:" + searchMedicineGoodsResultList.size());
            }
            PageInfo<SearchMedicineGoodsResult> pageInfo = new PageInfo<>(searchMedicineGoodsResultList);
            pageInfo.setTotal(total);
            return pageInfo;
        } catch (SolrServerException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        } catch (IOException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        }
    }

    private SearchMedicineGoodsResult dealMedicineGoods(SolrDocument solrDocument, boolean isLogin, int isControl) {
        logger.debug(solrDocument.get("medicineGoodsId").toString());
        SearchMedicineGoodsResult searchMedicineGoodsResult = new SearchMedicineGoodsResult();
        searchMedicineGoodsResult
                .setId(Integer.parseInt(solrDocument.get("medicineGoodsId").toString()));
        //添加库存信息
        if (isControl == 2) {
            Map param = new HashMap();
            param.put("medicineId", solrDocument.get("medicineGoodsId").toString());
            Integer stockNumber = searchJcMedicineResultMapper.getControlStockNumber(param);
            if (null!=stockNumber)
                searchMedicineGoodsResult.setStockNumber(stockNumber);
        }
        // 获取价格
        String price = dealMedicineGoodsPrice(solrDocument, isLogin, isControl);
        searchMedicineGoodsResult.setPrice(price);

        if (solrDocument.get("genericName") != null) {
            searchMedicineGoodsResult.setGenericName(solrDocument.get("genericName").toString());
        } else {
            searchMedicineGoodsResult.setGenericName("");
        }
        if (solrDocument.get("boxNum") != null) {
            searchMedicineGoodsResult.setBoxNum(solrDocument.get("boxNum").toString());
        } else {
            searchMedicineGoodsResult.setGenericName("");
        }
        if (solrDocument.get("tradeName") != null) {
            searchMedicineGoodsResult.setTradeName(solrDocument.get("tradeName").toString());
        } else {
            searchMedicineGoodsResult.setTradeName("");
        }
        if (solrDocument.get("imgUrl") != null) {
            searchMedicineGoodsResult.setImgUrl(solrDocument.get("imgUrl").toString());
        } else {
            searchMedicineGoodsResult.setImgUrl("");
        }
        if (solrDocument.get("specification") != null) {
            searchMedicineGoodsResult.setSpecification(solrDocument.get("specification").toString());
        } else {
            searchMedicineGoodsResult.setSpecification("");
        }
        if (solrDocument.get("dosageFormName") != null) {
            searchMedicineGoodsResult.setDosageFormName(solrDocument.get("dosageFormName").toString());
        } else {
            searchMedicineGoodsResult.setDosageFormName("");
        }
        if (solrDocument.get("boxNum") != null) {
            searchMedicineGoodsResult.setBoxNum(solrDocument.get("boxNum").toString());
        } else {
            searchMedicineGoodsResult.setBoxNum("");
        }
        if (solrDocument.get("produceEnterprice") != null) {
            searchMedicineGoodsResult
                    .setProduceEnterprice(solrDocument.get("produceEnterprice").toString());
        } else {
            searchMedicineGoodsResult.setProduceEnterprice("");
        }
        if (solrDocument.get("unitName") != null) {
            searchMedicineGoodsResult
                    .setUnitName(solrDocument.get("unitName").toString());
        } else {
            searchMedicineGoodsResult.setUnitName("");
        }
        if (solrDocument.get("approvalNum") != null) {
            searchMedicineGoodsResult.setApprovalNum(solrDocument.get("approvalNum").toString());
        } else {
            searchMedicineGoodsResult.setApprovalNum("");
        }
        if (solrDocument.get("companyId") != null) {
            searchMedicineGoodsResult.setCompanyId(solrDocument.get("companyId").toString());
        } else {
            searchMedicineGoodsResult.setCompanyId("");
        }
        if (solrDocument.get("companyName") != null) {
            searchMedicineGoodsResult.setCompanyName(solrDocument.get("companyName").toString());
        } else {
            searchMedicineGoodsResult.setCompanyName("");
        }

        return searchMedicineGoodsResult;
    }

    private String dealMedicineGoodsPrice(SolrDocument solrDocument, boolean isLogin, Integer isControl) {
        String price = "";
        if (isControl == 1) {
            if (!isLogin) {
                // 未登录，集採显示建议零售价
                if (solrDocument.get("suggestedPrice") != null) {
                    price = solrDocument.get("suggestedPrice").toString();
                }
            } else {
                //登录后，如果设置了会员组，取会员组价格，如果没有取供货价，没有供货价取建议零售价

                //取会员价
                String Id = solrDocument.get("medicineGoodsId").toString();
                Integer medicineId = Integer.parseInt(Id);
                List<JcSimplyCompany> companyList = JcUserFactory.getJcUserDetails().getCompanyList();
                if (null != companyList && 0 != companyList.size()) {
                    Integer companyId = companyList.get(0).getCompanyId();
                    Map param = new HashMap();
                    param.put("companyId", companyId);
                    param.put("medicineId", medicineId);
                    BigDecimal groupPrice = searchJcMedicineResultMapper.getGroupPrice(param);
                    if (groupPrice != null) price = groupPrice.toString();
                }
                if (price == "" || price == null) {
                    if (solrDocument.get("availabilityPrice") != null) {
                        price = solrDocument.get("availabilityPrice").toString();
                    } else if (solrDocument.get("suggestedPrice") != null) {
                        price = solrDocument.get("suggestedPrice").toString();
                    }
                }
            }
        } else {
            //未登录，控销不显示价格，登录后，如果授权了取授权价，未授权不显示价格       开始的方案:取供货价，没有供货价取建议零售价

            if (isLogin) {
                if (solrDocument.get("authorizationPrice") != null) {
                    price = solrDocument.get("authorizationPrice").toString();
                }
            }
        }
        return price;
    }

    /**
     * 渠道的上采目录列表
     *
     * @param page
     * @param medicineGoodsFilterParam
     * @return
     */
    @Override
    public PageInfo<CpMedicineGoodsResult> getControlPurchaseMedicineGoods(PageParam page, CpMedicineGoodsFilterParam medicineGoodsFilterParam) {

        JcUserDetails userDetails = JcUserFactory.getJcUserDetails();

        // 获取当前的渠道id
        Integer channelId = userDetails.getChannelId();

        PageInfo<CpMedicineGoodsResult> pageInfo = new PageInfo<>(new ArrayList<>());
        Byte userType = userDetails.getUserType();

        ChannelTypeGroupEnum channelTypeGroupEnum = ChannelTypeGroupEnum.getFromUserType(userType);
        // 判断当前的用户级别
        if (!ChannelTypeGroupEnum.CHANNEL.getValue().equals(channelTypeGroupEnum.getValue())) {
            throw new CustomServiceException(MedicineErrorCodeEnum.USETYPE_IS_ERROR.getCode(), MedicineErrorCodeEnum.USETYPE_IS_ERROR.getMessage());
        }

        // 个人版没有采购列表
        if(EnterpriseTypeEnum.PERSON.getValue().equals(userDetails.getEnterpriseType())){
            return new PageInfo<>(new ArrayList<>());
        }

        // 1. 获取当前用户的授权产品列表
        CpMedicineExample medicineExample = new CpMedicineExample();

        CpMedicineExample.Criteria criteria = medicineExample.createCriteria();
        criteria
                .andIsDeleteEqualTo(IsDeleteEnum.NORMAL.getValue())
                .andStatusEqualTo(MedicineStatusEnum.HAS_BEEN_SHELVED.getValue())
                .andApplyStatusEqualTo(ApplyStatusEnum.HAS_CHECKED.getValue())
                .andIsUseEqualTo(IsUseEnum.ENABLE.getValue())
                .andControlChannelIdEqualTo(channelId);

        if (medicineGoodsFilterParam.getCompanyId() != null) {
            criteria
                    .andCompanyIdEqualTo(medicineGoodsFilterParam.getCompanyId());
        }

        if (medicineGoodsFilterParam.getKeyWord() != null) {
            criteria
                    .andGenericNameLike(LikeValueFactory.arbitraryCreate(medicineGoodsFilterParam.getKeyWord()));
        }

        if(medicineGoodsFilterParam.getCompanyName() != null)
            criteria.andCompanyNameLike(LikeValueFactory.arbitraryCreate(medicineGoodsFilterParam.getCompanyName()));

        if(medicineGoodsFilterParam.getGenericName() != null)
            criteria.andGenericNameLike(LikeValueFactory.arbitraryCreate(medicineGoodsFilterParam.getGenericName()));

        if(medicineGoodsFilterParam.getTradeName() != null)
            criteria.andTradeNameLike(LikeValueFactory.arbitraryCreate(medicineGoodsFilterParam.getTradeName()));

        if(medicineGoodsFilterParam.getProduceEnterprice() != null)
            criteria.andProduceEnterpriceLike(LikeValueFactory.arbitraryCreate(medicineGoodsFilterParam.getProduceEnterprice()));

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<CpMedicineGoodsResult> medicineGoodsList = divisionMedicineAdviceMapper.getControlMedicineGoods(medicineExample);

        if (medicineGoodsList == null)
            return pageInfo;
        pageInfo = new PageInfo<>(medicineGoodsList);
        return pageInfo;
    }


    /**
     * 商品搜索关键词智能提示
     *
     * @param keywordSuggestParam
     * @return
     */
    @Override
    public PageInfo<KeywordSuggestResult> keywordSuggest(KeywordSuggestParam keywordSuggestParam) {
        SolrQuery query = new SolrQuery();

        String keyword = keywordSuggestParam.getKeyword();

        if (StringUtils.isBlank(keyword)) {
            keyword = "*";
        }
        if (null != keywordSuggestParam.getType() && keywordSuggestParam.getType() == 1) {
            query.set("qt", "/suggest");
        } else {
            query.set("qt", "/suggest2");
        }
        query.setQuery(keyword);

        solrClient = new HttpSolrClient(solrNoControlMedicineGoods);
        solrClient2 = new HttpSolrClient(solrControlMedicineGoods);
        int isControl1 = 1;
        int isControl2 = 2;
        List<KeywordSuggestResult> keywordSuggestResults = dealKeywordSuggestData(isControl2, solrClient2, keyword, query);
        List<KeywordSuggestResult> keywordSuggestResults1 = dealKeywordSuggestData(isControl1, solrClient, keyword, query);
        if (null != keywordSuggestResults) {
            keywordSuggestResults.addAll(keywordSuggestResults1);
        } else {
            keywordSuggestResults = keywordSuggestResults1;
        }
        PageInfo<KeywordSuggestResult> keywordSuggestResultPageInfo = new PageInfo<>(keywordSuggestResults);
        return keywordSuggestResultPageInfo;

    }


    /**
     * 处理商品搜索关键词提示数据
     *
     * @return
     */
    private List<KeywordSuggestResult> dealKeywordSuggestData(int isControl, SolrClient solrClient, String keyword, SolrQuery query) {
        try {
            List<KeywordSuggestResult> keywordSuggestResultList = new ArrayList<>();
            query.setStart(SEARCH_START);
            query.setRows(SUGGEST_PAGE_SIZE);

            QueryResponse queryResponse = solrClient.query(query);

            GetSuggest(isControl, solrClient, keyword, keywordSuggestResultList, queryResponse);

            return keywordSuggestResultList;
        } catch (SolrServerException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        } catch (IOException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        }
    }

    private void GetSuggest(int isControl, SolrClient solrClient, String keyword, List<KeywordSuggestResult> keywordSuggestResultList, QueryResponse queryResponse) {
        SuggesterResponse suggest = queryResponse.getSuggesterResponse();
        Map<String, List<Suggestion>> mapSuggestions = suggest.getSuggestions();

        for (Map.Entry<String, List<Suggestion>> entry : mapSuggestions.entrySet()) {
            List<Suggestion> valueList = entry.getValue();
            for (Suggestion suggestion : valueList) {
                String term = suggestion.getTerm();
                if (term.startsWith(keyword)) {
                    KeywordSuggestResult keywordSuggestResult = new KeywordSuggestResult();
                    keywordSuggestResult.setKeyword(keyword);
                    keywordSuggestResult.setSuggestWord(term);
                    keywordSuggestResult.setType(isControl);
                    keywordSuggestResultList.add(keywordSuggestResult);
                }

            }
        }
    }
}
