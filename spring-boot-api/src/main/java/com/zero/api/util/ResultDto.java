package com.zero.api.util;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author admin
 * @date 2020/8/4-15:53
 */
@Getter
public class ResultDto<T>  implements Serializable {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultDto() {
    }

    public ResultDto(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultDto(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public ResultDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }


}
