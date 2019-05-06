package com.jc519.search.service.search;


public interface SearchImportService {

	/**
	 * 全量导入索引库
	 * @return
	 * @throws Exception
	 */
	String importData() throws Exception;

    /**
     * 更新索引库
     * @return
     * @throws Exception
     */
	String updateIndex() throws Exception;

}
