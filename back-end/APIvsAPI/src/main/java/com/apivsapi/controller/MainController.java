package com.apivsapi.controller;

import com.apivsapi.model.User;
import com.apivsapi.service.IUserService;
import com.apivsapi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan
public class MainController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value="home.do", method= RequestMethod.GET)
    public String helloWorld() {
        return "Hello Mingyu";
    }
    @RequestMapping(value="aws.do", method=RequestMethod.GET)
    public String getAllUser(){
        List<User> list = userService.getAllUser();
        if(list.size() == 0){
            return "list size is Zero";
        }else {
            return "list size is" + list.size();
        }
    }
}
