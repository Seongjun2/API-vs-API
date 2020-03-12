package com.apivsapi.dao;

import com.apivsapi.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDao {
    String ns = "apivsapi.user.";

    @Autowired
    private SqlSession sqlSession;

    public List<User> getAllUser() {
        return sqlSession.selectList(ns+"getAllUser");
    }
}
