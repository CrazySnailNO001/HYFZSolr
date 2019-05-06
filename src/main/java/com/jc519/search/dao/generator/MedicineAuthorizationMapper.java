package com.jc519.search.dao.generator;

import com.jc519.search.model.generator.MedicineAuthorization;
import com.jc519.search.model.generator.MedicineAuthorizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicineAuthorizationMapper {
    long countByExample(MedicineAuthorizationExample example);

    int deleteByExample(MedicineAuthorizationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineAuthorization record);

    int insertSelective(MedicineAuthorization record);

    List<MedicineAuthorization> selectByExample(MedicineAuthorizationExample example);

    MedicineAuthorization selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MedicineAuthorization record, @Param("example") MedicineAuthorizationExample example);

    int updateByExample(@Param("record") MedicineAuthorization record, @Param("example") MedicineAuthorizationExample example);

    int updateByPrimaryKeySelective(MedicineAuthorization record);

    int updateByPrimaryKey(MedicineAuthorization record);
}