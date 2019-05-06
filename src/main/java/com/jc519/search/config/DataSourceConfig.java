package com.jc519.search.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.jc519.search.dao", sqlSessionTemplateRef  = "jcSqlSessionTemplate")
public class DataSourceConfig {

//    @Bean(name = "jcDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.jc")
//    @Primary
//    public DataSource jcDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    @Bean(name = "jcSqlSessionFactory")
    @Primary
    public SqlSessionFactory jcSqlSessionFactory(@Qualifier("jcDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/com/jc519/**/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "jcTransactionManager")
    @Primary
    public DataSourceTransactionManager jcTransactionManager(@Qualifier("jcDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "jcSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate jcSqlSessionTemplate(@Qualifier("jcSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}