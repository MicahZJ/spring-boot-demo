package com.mazj.utils;

public enum ResultCode {
    /**
     * 系统繁忙
     */
    SYSTEM_BUSY(-1,"系统繁忙，请稍后重试！"),

    /**
     * 请求成功
     */
    REQ_SUCCESS(200,"请求成功！"),

    /**
     * 签名错误
     */
    SIG_ERROR(4001,"签名错误！"),

    /**
     * token验证失败
     */
    TOKEN_ERROR(4002,"token校验失败！"),

    /**
     * 缺少参数
     */
    MISSING_PARAM(4003,"缺少必要的参数！"),

    /**
     * 参数错误
     */
    PARAM_ERROR(4004,"参数错误"),

    /**
     * 未知异常
     */
    REQ_ERROR(4005,"请求失败！"),

    /**
     * 未知异常
     */
    UP_ERROR(4006,"添加失败！"),

    /**
     * 请求中的时间戳和服务端接收到请求的时间间隔大于五秒返回该异常
     */
    TIMEOUT_ERROR(4007,"请求超时，检查网络环境是否良好！"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(500,"系统错误，请联系技术人员！");

    private int code;

    private String msg;

    ResultCode(int code, String s) {
        this.code = code;
        this.msg = s;
    }
}
