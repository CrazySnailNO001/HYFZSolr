package com.jc519.search.service.search;

import com.github.pagehelper.PageInfo;
import com.jc519.search.web.rest.search.param.CpMedicineGoodsFilterParam;
import com.jc519.search.web.rest.search.param.KeywordSuggestParam;
import com.jc519.search.web.rest.search.param.PageParam;
import com.jc519.search.web.rest.search.param.SearchMedicineGoodsParam;
import com.jc519.search.web.rest.search.result.CpMedicineGoodsResult;
import com.jc519.search.web.rest.search.result.KeywordSuggestResult;
import com.jc519.search.web.rest.search.result.SearchMedicineGoodsResult;
import org.apache.solr.client.solrj.response.TermsResponse;

import java.util.List;

public interface SearchService {

	/**
	 * 商品搜索关键词提示
	 * @param keywordSuggestParam
	 * @return
	 */
	PageInfo<KeywordSuggestResult> keywordSuggest(KeywordSuggestParam keywordSuggestParam);

	/**
	 * 搜索商品列表
	 *
	 * @param searchMedicineGoodsParam
	 * @return
	 */
	PageInfo<SearchMedicineGoodsResult> searchMedicineGoods(SearchMedicineGoodsParam searchMedicineGoodsParam);


	/**
	 * 搜索热词
	 * @return
	 */
	List<String> searchHotWords();

	/**
	 * 控销药品商品列表
	 * @param page
	 * @param medicineGoodsFilterParam
	 * @return
	 */
	PageInfo<CpMedicineGoodsResult> getControlPurchaseMedicineGoods(PageParam page, CpMedicineGoodsFilterParam medicineGoodsFilterParam);

}
