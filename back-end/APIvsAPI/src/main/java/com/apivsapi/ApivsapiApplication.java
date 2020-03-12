package com.apivsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration(exclude = {DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = "com.apivsapi.controller")
//@ComponentScan

@SpringBootApplication
@EnableTransactionManagement
public class ApivsapiApplication{
    public static void main(String[] args) {
        SpringApplication.run(ApivsapiApplication.class, args);
    }
}
