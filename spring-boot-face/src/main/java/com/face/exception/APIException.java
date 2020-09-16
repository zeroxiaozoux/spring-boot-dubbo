package com.face.exception;

import lombok.Getter;

/**
 * @author zero
 * @date 2020/8/4-15:45
 */
@Getter
public class APIException extends RuntimeException {
    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
