package com.example.demo.service.impl;

import com.example.demo.Thread.ExecutorConfig;
import com.example.demo.controller.Timer;
import com.example.demo.dao.UserMapper;
import com.example.demo.redis.RedisClientTemplate;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisClientTemplate redisClientTemplate;
    @Autowired
    private ExecutorConfig executorConfig;

    @Override
    public String getName() {
        try {

            Executor executor = executorConfig.asyncServiceExecutor();
            executor.execute(new Timer());
            Map<String, Object> name = userMapper.getName();
            log.info(name.toString());
        } catch (Exception e) {
            log.info("出现了异常{}", e);
        }
        return "success";
    }

    @Override
    public Integer insertForeach(List<Map<String, Object>> list) {
        int i = 0;
        try {
            List<Map<String, Object>> list2 = new ArrayList<>();
            Map<String, Object> map1 = new HashMap<>();
            map1.put("name", null);
            map1.put("age", null);
            list2.add(map1);
            i = userMapper.insertForeach(list);
            i = userMapper.insertForeach(list2);

        } catch (Exception e) {
            log.info("插入异常" + e);
        }

        return i;
    }

}
