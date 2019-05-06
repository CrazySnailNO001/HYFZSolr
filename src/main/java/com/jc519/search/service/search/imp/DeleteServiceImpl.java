package com.jc519.search.service.search.imp;

import com.jc519.common.errorcode.ErrorCodeEnum;
import com.jc519.common.web.rest.errors.CustomServiceException;
import com.jc519.search.service.search.DeleteService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author XZHH
 * @create 2018/3/6 0006 17:44
 **/
@Service
public class DeleteServiceImpl implements DeleteService{
    @Autowired
    private SolrClient solrClient;

    @Value("${spring.data.solr.collection.noControlMedicineGoods}")
    private String solrNoControlMedicineGoods;

    @Value("${spring.data.solr.collection.controlMedicineGoods}")
    private String solrControlMedicineGoods;

    @Value("${spring.data.solr.collection.hotWords}")
    private String hotWords;

    @Override
    public void deleteHotWordsIndex() {
        solrClient = new HttpSolrClient(hotWords);
        try {
            solrClient.deleteByQuery("*:*");
            solrClient.commit();
            solrClient.close();
        } catch (SolrServerException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        } catch (IOException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        }
    }

    @Override
    public void deleteNoControlIndex() {
        solrClient = new HttpSolrClient(solrNoControlMedicineGoods);
        try {
            solrClient.deleteByQuery("*:*");
            solrClient.commit();
            solrClient.close();
        } catch (SolrServerException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        } catch (IOException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        }
    }

    @Override
    public void deleteControlIndex() {
        solrClient = new HttpSolrClient(solrControlMedicineGoods);
        try {
            solrClient.deleteByQuery("*:*");
            solrClient.commit();
            solrClient.close();
        } catch (SolrServerException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        } catch (IOException e) {
            throw new CustomServiceException(ErrorCodeEnum.DATA_NOT_EXIST.getCode(), ErrorCodeEnum.DATA_NOT_EXIST.getMessage());
        }
    }
}
