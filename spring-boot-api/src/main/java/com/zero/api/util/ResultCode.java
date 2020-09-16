package com.zero.api.util;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author admin
 * @date 2020/8/4-16:02
 */
@Getter
public enum  ResultCode  implements Serializable {
    SUCCESS(1000, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
