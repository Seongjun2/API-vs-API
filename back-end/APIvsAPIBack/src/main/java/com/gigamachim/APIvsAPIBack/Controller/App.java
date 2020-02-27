package com.gigamachim.APIvsAPIBack.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class App implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(App.class);

    @Autowired
    TestMapper testMapper;

    public static void main(String[] args){
        new SpringApplicationBuilder(App.class).build().run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("준비");

        int point = 0;

        testMapper.getUserList().stream().forEach(ac ->logger.info(ac.toString()));
    }
}
