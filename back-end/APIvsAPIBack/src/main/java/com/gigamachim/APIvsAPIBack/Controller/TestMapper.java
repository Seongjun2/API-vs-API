package com.gigamachim.APIvsAPIBack.Controller;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("Select * from Test")
    List<Test> getUserList();
}
