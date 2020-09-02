package com.mazj.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {
    private String msg;
    private Object data;
    private Object code;

    public ResultInfo successInfo(ResultCode msg, Object data) {
        return new ResultInfo(msg.getMsg(), data, msg.getCode());
    }

    public ResultInfo errInfo(ResultCode msg) {
        return new ResultInfo(msg.getMsg(), "", msg.getCode());
    }

}
