package com.assertsolutions.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("${CONFIG_LOCATION}kafka-producer.properties")
@PropertySource("${CONFIG_LOCATION}db-postgresql.properties")
//@PropertySource("classpath:kafka-producer.properties")
public class RouteConfig {

}