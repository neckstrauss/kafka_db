package com.assertsolutions.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Assert Solutions S.A.S
 *
 */
@Configuration
public class DatabaseConnectionConfig {

    @Bean("dataSource")
    @ConfigurationProperties(prefix = "db.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(BasicDataSource.class).build();
    }

}
