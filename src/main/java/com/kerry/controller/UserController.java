package com.kerry.controller;

import com.kerry.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户模块", tags = "用户管理模块接口")
@RestController
public class UserController {
    private static List<User> userList = new ArrayList<User>();

    static {
        userList.add(new User(10, "张三"));
        userList.add(new User(20, "李四"));
        userList.add(new User(30, "王五"));
    }

    @ApiOperation(value = "获取用户列表", notes = "获取所有用户的信息")
    @ResponseBody
    @GetMapping("/users")
    public Object getAllUser() {
        Map<String, List<User>> map = new HashMap<>();
        map.put("users", userList);
        return map;
    }

}
