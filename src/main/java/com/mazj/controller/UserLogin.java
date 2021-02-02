package com.mazj.controller;

import com.alibaba.fastjson.JSONObject;
import com.mazj.mapper.UserMapper;
import com.mazj.pojo.User;
import com.mazj.utils.ResultCode;
import com.mazj.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/api/login")
@RestController
public class UserLogin {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/account")
    public ResultInfo queryUserById (@RequestBody JSONObject obj) {
        int userList = userMapper.queryUserById(JSONObject.toJavaObject(obj, User.class)).size();
        if (userList == 1) {
            return new ResultInfo().successInfo(ResultCode.REQ_SUCCESS, "");
        }
        return new ResultInfo().errInfo(ResultCode.REQ_ERROR);
    }
}
