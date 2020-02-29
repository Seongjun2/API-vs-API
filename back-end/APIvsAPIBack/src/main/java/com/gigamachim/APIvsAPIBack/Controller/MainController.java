package com.gigamachim.APIvsAPIBack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private PersonDAO personDAO;

    @RequestMapping(value = "/mybatis.do", method = RequestMethod.GET)
    public String home(){

        return String.format("%s %s", personDAO.selectName(), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//        return "home";
    }

    @Autowired
    private TestDAO testDao;

    @RequestMapping(value = "/aws.do", method = RequestMethod.GET)
    public String aws(){
        return String.format("%s %s", testDao.selectTestName(), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
