package com.gigamachim.APIvsAPIBack.Controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
