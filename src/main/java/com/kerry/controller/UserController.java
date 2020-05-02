package com.kerry.controller;

import com.kerry.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户模块", tags = "用户管理模块接口")
@RestController
@RequestMapping("/user")
public class UserController {
    private static List<User> userList = new ArrayList<User>();

    // 模拟数据块数据
    static {
        userList.add(new User(10, "张三"));
        userList.add(new User(20, "李四"));
        userList.add(new User(30, "王五"));
    }

    @ApiOperation(value = "获取用户列表", notes = "获取所有用户的信息")
    @ResponseBody
    @GetMapping("/list")
    public Object getAllUser() {
        Map<String, List<User>> map = new HashMap<>();
        map.put("users", userList);
        return map;
    }

    @ApiOperation(value = "获取单个用户", notes = "根据ID查询某个用户的信息")
    @ApiImplicitParam(value = "用户的ID", paramType = "path")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userList.get(id);
    }

    @ApiOperation(value = "添加用户", notes = "根据传入的用户信息添加用户")
    @ApiImplicitParam(value = "用户对象", paramType = "query")
    @PostMapping("/add")
    public Object add(User user){
        return userList.add(user);
    }

    @ApiOperation(value = "删除用户",notes = "根据传入的用户ID删除对应的用户")
    @ApiImplicitParam(value = "用户的ID", paramType = "path")
    @DeleteMapping("/delete/{id}")
    public Object deleteById(@PathVariable("id") int id){
        return userList.remove(id);
    }
}