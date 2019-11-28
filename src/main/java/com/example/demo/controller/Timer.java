package com.example.demo.controller;

import com.example.demo.redis.RedisClientTemplate;
import com.example.demo.springConfig.SpringUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Timer implements Runnable {


    @Override
    public void run() {

        boolean tttt = SpringUtil.getBean(RedisClientTemplate.class).setKey("tttt", "11111");
        if (tttt) {
            log.info("执行成功");
        } else {
            log.error("执行失败");
        }
    }
}
