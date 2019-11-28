package com.example.demo.controller;

import com.example.demo.redis.RedisClientTemplate;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

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

    /**
     * @param list
     * @return
     */
    @PostMapping(value = "/insertUser")

    public void insertUser(@RequestBody String list) {


        JSONObject listJson = JSONObject.fromObject(list);
        JSONObject params = listJson.optJSONObject("params");
        JSONArray list1 = params.optJSONArray("list");
        userService.insertForeach(list1);

        log.info("执行完了");

    }

}
