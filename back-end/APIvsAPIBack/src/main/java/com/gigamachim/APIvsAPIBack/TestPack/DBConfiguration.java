package com.gigamachim.APIvsAPIBack.TestPack;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

public class DBConfiguration {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(ds);
        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/pgsql.xml"));

        return factory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }
}
