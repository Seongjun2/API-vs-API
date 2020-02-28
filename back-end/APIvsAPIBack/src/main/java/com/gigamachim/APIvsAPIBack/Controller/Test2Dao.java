package com.gigamachim.APIvsAPIBack.Controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Test2Dao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<Test2Dto> sel(){
        return sqlSession.selectList("sql.sel");
    }

}
