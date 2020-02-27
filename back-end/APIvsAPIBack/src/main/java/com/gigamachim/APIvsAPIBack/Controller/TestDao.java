package com.gigamachim.APIvsAPIBack.Controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestDao implements TestMapper{

    @Autowired
    @Qualifier("MyBatis_PostgreSQL_SqlSessionTemplate")
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Test> getUserList() {
        return null;
    }

}
