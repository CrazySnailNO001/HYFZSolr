package com.jc519.search.service.search;

/**
 * @author XZHH
 * @create 2018/3/6 0006 17:44
 **/
public interface DeleteService {
    void deleteHotWordsIndex();

    void deleteNoControlIndex();

    void deleteControlIndex();
}
