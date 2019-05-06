package com.jc519.search.dao;

import com.jc519.search.model.AllControlMedicineResult;
import com.jc519.search.model.SearchJcMedicineResult;
import com.jc519.search.model.generator.MedicineAuthorization;
import com.jc519.search.model.ControlMedicineGood;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SearchJcMedicineResultMapper {

    List<SearchJcMedicineResult> selectJcMedicineResult(Map param);

    List<MedicineAuthorization> selectDivisionMedicineAuthorizationList(Map param);

    List<MedicineAuthorization> selectUserMedicineAuthorizationList(Map param);

    BigDecimal getGroupPrice(Map param);

    List<Integer> getUpdateControlIds(Map param);

    List<Integer> getUpdateNoControlIds(Map param);

    List<SearchJcMedicineResult> getNoControlGoods(Map param);

    List<SearchJcMedicineResult> getUpdaControlGoods(Map param);

    List<String> getControlDeleteNames(Map param);

    List<String> getNoControlDeleteNames(Map param);

    List<String> getAddNames(Map param);

    List<Integer> getExitProduct(Map param);

    Integer getControlStockNumber(Map param);

    List<AllControlMedicineResult> selectAllControlMedicine();
}