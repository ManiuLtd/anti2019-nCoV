package com.anti.donation.configuration;

import com.github.pagehelper.PageHelper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author ：nelsonsunxin@didichuxing.com
 * @date ：Created in 2020-01-26 13:18
 * @description：TODO
 * @modified By：
 * @version:
 */
@Configuration
@MapperScan(basePackages = "com.anti.donation.infrastructure.persistence.mybatis.mapper", sqlSessionTemplateRef = "antiSqlSessionTemplate")

public class DataSourceConfig {

    @Bean(name = "antiDataSource")
    @Qualifier("antiDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.anti")
    public DataSource antiDataSource() {
        DataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        return dataSource;
    }

    @Bean(name = "antiSqlSessionFactory")
    public SqlSessionFactory AntiSqlSessionFactory(@Qualifier("antiDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/anti/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "antiTransactionManager")
    public DataSourceTransactionManager AntiTransactionManager(
            @Qualifier("antiDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "antiSqlSessionTemplate")
    public SqlSessionTemplate AntiSqlSessionTemplate(
            @Qualifier("antiSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
