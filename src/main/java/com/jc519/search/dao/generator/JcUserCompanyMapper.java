package com.jc519.search.dao.generator;

import com.jc519.search.model.generator.JcUserCompany;
import com.jc519.search.model.generator.JcUserCompanyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JcUserCompanyMapper {
    long countByExample(JcUserCompanyExample example);

    int deleteByExample(JcUserCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JcUserCompany record);

    int insertSelective(JcUserCompany record);

    List<JcUserCompany> selectByExample(JcUserCompanyExample example);

    JcUserCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JcUserCompany record, @Param("example") JcUserCompanyExample example);

    int updateByExample(@Param("record") JcUserCompany record, @Param("example") JcUserCompanyExample example);

    int updateByPrimaryKeySelective(JcUserCompany record);

    int updateByPrimaryKey(JcUserCompany record);
}