package com.zero.api.util;

/**
 * @author zero
 * @date 2020/8/24-18:26
 */
public class ResultUtils {
    public static <T> ResultDto<T> success() {
        return new ResultDto<T>(ResultCode.SUCCESS, null);
    }

    public  static <T> ResultDto<T> error(){
        return new ResultDto<>(ResultCode.FAILED,null);
    }

    public  static <T> ResultDto<T> error(String message){
        return new ResultDto<>(ResultCode.FAILED.getCode(),message);
    }

    public static <T> ResultDto<T> successForData(T data) {
        return new ResultDto<T>(ResultCode.SUCCESS, data);
    }
}
