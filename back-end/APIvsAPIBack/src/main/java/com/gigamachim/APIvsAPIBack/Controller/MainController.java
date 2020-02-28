package com.gigamachim.APIvsAPIBack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @RequestMapping(value="home.do",method = RequestMethod.GET)
    public String printHello(){
        return "Hello World hahaha";
    }
    @RequestMapping(value="test.do",method = RequestMethod.GET)
    public String printHello2(){
        return "We go Vue";
    }

    @Autowired
    Test2Dao test2Dao;

    @RequestMapping(value = "/mybatis.do", method = RequestMethod.GET)
    public String home(Model md){
        List<Test2Dto> list = test2Dao.sel();
        for (int i = 0; i < list.size(); i++) {
            md.addAttribute("NAME", list.get(0).getName());
        }

        return "home";
    }
}
