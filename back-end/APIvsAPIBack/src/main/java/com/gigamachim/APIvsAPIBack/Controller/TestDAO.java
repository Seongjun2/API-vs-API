package com.gigamachim.APIvsAPIBack.Controller;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
    protected static final String NAMESPACE = "com.gigamachim.APIvsAPIBack.Controller";

    @Autowired
    private SqlSession sqlSession;

    public String selectTestName(){
        System.out.println("test");
        return sqlSession.selectOne("selectTestName");
    }
}
