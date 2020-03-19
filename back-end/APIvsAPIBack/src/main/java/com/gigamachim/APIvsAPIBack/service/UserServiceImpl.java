package com.gigamachim.APIvsAPIBack.service;


import com.gigamachim.APIvsAPIBack.dao.UserDao;
import com.gigamachim.APIvsAPIBack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


}
