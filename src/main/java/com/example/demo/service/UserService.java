package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    String getName();

    Integer insertForeach(List<Map<String, Object>> list);
}
