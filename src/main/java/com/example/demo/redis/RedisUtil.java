package com.example.demo.redis;

import com.example.demo.springConfig.SpringUtil;

public class RedisUtil {
    public static RedisClientTemplate getRedisTemplate() {
        return (RedisClientTemplate) SpringUtil.getBean("redisClientTemplate");
    }


}
