package com.mazj.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mazj.mapper.UserMapper;
import com.mazj.pojo.User;
import com.mazj.utils.ResultCode;
import com.mazj.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.JavaObjectOpMessage;

import java.util.HashMap;
import java.util.List;
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUser")
    public ResultInfo queryUserList () {
        List<User> userList = userMapper.queryUserList();
        if (userList == null) {
            return new ResultInfo().successInfo(ResultCode.REQ_SUCCESS, "");
        }
        HashMap<Object, Object> map = new HashMap<>();
        map.put("queryData", userList);
        return new ResultInfo().successInfo(ResultCode.REQ_SUCCESS, map);
    }

    @PostMapping("/addUser")
    public ResultInfo addUserList (@RequestBody JSONObject addObj) {
        int userList = userMapper.addUser(JSONObject.toJavaObject(addObj, User.class));
        if (userList >= 1) {
            return new ResultInfo().successInfo(ResultCode.REQ_SUCCESS, "");
        } else {
            return new ResultInfo().errInfo(ResultCode.UP_ERROR);
        }
    }
}
