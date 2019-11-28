package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    /**
     * 获取姓名
     *
     * @return
     */
    Map<String, Object> getName();

    Integer insertForeach(List<Map<String, Object>> list);
}
