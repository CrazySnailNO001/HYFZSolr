package com.jc519.search.web.rest.search;

import com.github.pagehelper.PageInfo;
import com.jc519.search.service.search.SearchService;
import com.jc519.search.web.rest.search.param.CpMedicineGoodsFilterParam;
import com.jc519.search.web.rest.search.param.KeywordSuggestParam;
import com.jc519.search.web.rest.search.param.PageParam;
import com.jc519.search.web.rest.search.param.SearchMedicineGoodsParam;
import com.jc519.search.web.rest.search.result.CpMedicineGoodsResult;
import com.jc519.search.web.rest.search.result.KeywordSuggestResult;
import com.jc519.search.web.rest.search.result.SearchMedicineGoodsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.solr.client.solrj.response.TermsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@Api(value = "搜索服务", tags = "搜索服务")
@RestController
public class SearchController {
    private final static Integer IS_CONTROL = 2;
    @Autowired
    SearchService searchService;

    /**
     * 商品搜索关键词提示
     *
     * @param keywordSuggestParam
     * @return
     */
    @ApiOperation(value = "商品搜索关键词提示", notes = "商品搜索关键词提示")
    @GetMapping(value = "/medicineGoods/keywordSuggest")
    public PageInfo<KeywordSuggestResult> keywordSuggest(KeywordSuggestParam keywordSuggestParam) {
        return searchService.keywordSuggest(keywordSuggestParam);
    }

    /**
     * 搜索商品列表
     *
     * @param searchMedicineGoodsParam
     * @return
     */
    @ApiOperation(value = "搜索商品列表", notes = "搜索商品列表")
    @GetMapping(value = "/medicineGoods")
    public PageInfo<SearchMedicineGoodsResult> searchMedicineGoods(SearchMedicineGoodsParam searchMedicineGoodsParam) {
        return searchService.searchMedicineGoods(searchMedicineGoodsParam);
    }

    /**
     * 搜索热词
     * @return
     */
    @ApiOperation(value = "搜索热词", notes = "搜索热词")
    @GetMapping(value = "/hotWords")
    public List<String> keywordSuggest() {
        return searchService.searchHotWords();
    }

    /**
     * 首页数据集
     * @param pageParam
     * @param type
     * @return
     */
    @ApiOperation(value = "首页数据集", notes = "数据集")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型（1-化学药品，2-中药饮品）", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/innerMedicine")
    public PageInfo<SearchMedicineGoodsResult> getInnerMedicine(@ApiIgnore PageParam pageParam, @ApiIgnore Integer type) {

        SearchMedicineGoodsParam searchMedicineGoodsParam = new SearchMedicineGoodsParam();

        searchMedicineGoodsParam.setPageNum(pageParam.getPageNum());
        searchMedicineGoodsParam.setIsControl(IS_CONTROL);
        searchMedicineGoodsParam.setPageSize(pageParam.getPageSize());
        searchMedicineGoodsParam.setGenericCateId(type);

        return searchService.searchMedicineGoods(searchMedicineGoodsParam);
    }

    /**
     * 控销各级的药品列表(商品)(省地县上采列表)
     * @param page
     * @param medicineGoodsFilterParam
     * @return
     */
    @ApiOperation(value = "控销各级的药品列表(上级授权(发布)的药品)(商品)(省地县上采列表)", notes = "控销各级的药品列表（商品）(省地县上采列表)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "genericName", value = "通用名称", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "tradeName", value = "商品名称", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "produceEnterprice", value = "生产企业", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "companyName", value = "供应商名称", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "companyId", value = "供应商Id", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "keyWord", value = "搜索关键字", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "isUse", value = "状态", required = false, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/controlPurchase/medicineGoods")
    public PageInfo<CpMedicineGoodsResult> getControlPurchaseMedicineGoods(@ApiIgnore PageParam page, @ApiIgnore CpMedicineGoodsFilterParam medicineGoodsFilterParam) {

        return searchService.getControlPurchaseMedicineGoods(page, medicineGoodsFilterParam);
    }
    public static void main(String[] args){
        System.out.println(a());
    }
    public static String a(){
        String a = "2";
        try {
            return a;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            a = "-1";
            System.out.println("finally:"+a);
//            return a;
        }
        return "0";
    }
}
