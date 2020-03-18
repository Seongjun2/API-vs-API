package com.gigamachim.APIvsAPIBack.service;

import com.gigamachim.APIvsAPIBack.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public PersonDAO personDAO;

    @Override
    public String getName() {
        return null;
    }


//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public List<User> getAllUser() {
//        return userDao.getAllUser();
//    }
}
