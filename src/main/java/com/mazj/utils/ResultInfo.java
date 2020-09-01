package com.mazj.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {
    private ResultCode msg;
    private Object data;

    public ResultInfo successInfo(ResultCode msg, Object data) {
        return new ResultInfo(msg, data);
    }

    public ResultInfo errInfo(ResultCode msg, Object data) {
        return new ResultInfo(msg, data);
    }

}
