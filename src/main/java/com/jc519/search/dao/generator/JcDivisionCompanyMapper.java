package com.jc519.search.dao.generator;

import com.jc519.search.model.generator.JcDivisionCompany;
import com.jc519.search.model.generator.JcDivisionCompanyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JcDivisionCompanyMapper {
    long countByExample(JcDivisionCompanyExample example);

    int deleteByExample(JcDivisionCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JcDivisionCompany record);

    int insertSelective(JcDivisionCompany record);

    List<JcDivisionCompany> selectByExample(JcDivisionCompanyExample example);

    JcDivisionCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JcDivisionCompany record, @Param("example") JcDivisionCompanyExample example);

    int updateByExample(@Param("record") JcDivisionCompany record, @Param("example") JcDivisionCompanyExample example);

    int updateByPrimaryKeySelective(JcDivisionCompany record);

    int updateByPrimaryKey(JcDivisionCompany record);
}