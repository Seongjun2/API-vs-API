package com.gigamachim.APIvsAPIBack.Controller;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfiguration {

    @Configuration
    @MapperScan
            (
                    basePackages = "saro.webtest.mybatis.mapper",
                    sqlSessionFactoryRef = "MyBatis_PostgreSQL_DataSource",
                    sqlSessionTemplateRef = "MyBatis_PostgreSQL_SqlSessionFactory"
            )

    public static class Mybatis_PostgreSQL{
        @Autowired
        ApplicationContext applicationContext;


        //pgsql.properties 를 읽는 부분 인듯 ?
        @Bean(name = "MyBatis_PostgreSQL_DataSource")
        public DataSource getDataSource() throws IOException{
            Properties prop = new Properties();
            prop.load(DataSourceFactory.class.getClassLoader().getResourceAsStream("pgsql.properties"));
            return new HikariDataSource(new HikariConfig(prop));
        }

        @Bean(name ="MyBatis_PostgreSQL_SqlSessionFactory")
        public SqlSessionFactory getSqlSessionFactory() throws Exception{
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(getDataSource());
            //xml 매핑을 위한 것이므로 xml을 통해 매핑하지 않는다면 생략 가
            sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/*.xml"));
            
            return sqlSessionFactoryBean.getObject();
        }

        @Bean(name="MyBatis_PostgreSQL_SqlSessionTemplate")
        public SqlSessionTemplate getSqlSessionTemplate() throws Exception{
            return new SqlSessionTemplate(getSqlSessionFactory());
        }
    }
}
