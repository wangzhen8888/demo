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

}
