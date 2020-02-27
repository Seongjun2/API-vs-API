package com.gigamachim.APIvsAPIBack.TestPack;


public class App {

    public TestMapper mapper;

    public void test(){
        Object result = mapper.findAll();
    }

    public static void main(String[] args) {
    }
}
