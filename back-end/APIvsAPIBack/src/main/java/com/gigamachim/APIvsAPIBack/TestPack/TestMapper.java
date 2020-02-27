package com.gigamachim.APIvsAPIBack.TestPack;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {

    public List<Map<String,String>> findAll();
}
