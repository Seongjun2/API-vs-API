package com.gigamachim.APIvsAPIBack.TestPack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class App1 {

    public TestMapper mapper;

    public static void main(String[] args){
        new SpringApplicationBuilder(App1.class).build().run(args);

        App1 a = new App1();
        a.test();
    }

    public void test(){
        Object result = mapper.findAll();

        System.out.println(result.toString());
    }

}
