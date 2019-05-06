package com.jc519.search.dao;

import com.jc519.search.model.CpMedicineExample;
import com.jc519.search.web.rest.search.result.CpDivisionMedicineResult;
import com.jc519.search.web.rest.search.result.CpMedicineGoodsResult;

import java.util.List;

public interface JcDivisionMedicineAdviceMapper {

    /**
     * 获取控销药品商品列表
     * @return
     */
    List<CpMedicineGoodsResult> getControlMedicineGoods(CpMedicineExample cpMedicineExample);


}
