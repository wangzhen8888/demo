package com.example.demo.controller;

import com.example.demo.redis.RedisClientTemplate;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisClientTemplate redisClientTemplate;

    /**
     * @param sss
     * @return
     */
    @PostMapping(value = "/getName")

    public void getName(@RequestBody String sss) {
        userService.getName();
        log.info("执行完了");

    }

}
