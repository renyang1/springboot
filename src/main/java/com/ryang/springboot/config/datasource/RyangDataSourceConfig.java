package com.ryang.springboot.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @Auther: renyang
 * @Date: 2019/7/1 17:48
 * @Description: 数据库实例ryang数据源配置类
 */
@Configuration
@MapperScan(basePackages = "com.ryang.springboot.mapper.ryang", sqlSessionTemplateRef = "ryangSqlSessionTemplate")
public class RyangDataSourceConfig {

    @Bean(name = "ryangDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.ryang")
    @Primary
    public DruidDataSource ryangDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "ryangSqlSessionFactory")
    @Primary
    public SqlSessionFactory ryangSsqlSessionFactory(@Qualifier("ryangDataSource") DruidDataSource druidDataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(druidDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "ryangTransactionManager")
    @Primary
    public DataSourceTransactionManager ryangTransactionManager(@Qualifier("ryangDataSource") DruidDataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ryangSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate ryangSqlSessionTemplate(@Qualifier("ryangSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
