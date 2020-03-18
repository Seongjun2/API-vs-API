package com.gigamachim.APIvsAPIBack.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO {

    @Autowired
    private SqlSession sqlSession;

    public String selectName(){
        System.out.println("test");
        return sqlSession.selectOne("selectName");
    }
}
