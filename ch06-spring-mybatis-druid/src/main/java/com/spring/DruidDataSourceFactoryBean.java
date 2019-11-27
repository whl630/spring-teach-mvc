package com.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.FactoryBean;

import javax.sql.DataSource;

/**
 * @author cj
 * @date 2019/10/22
 */
public class DruidDataSourceFactoryBean implements FactoryBean<DataSource> {
    @Override
    public DataSource getObject() throws Exception {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setPassword("root");
        druidDataSource.setUsername("root");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        return druidDataSource;
    }

    @Override
    public Class<?> getObjectType() {
        return DataSource.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
