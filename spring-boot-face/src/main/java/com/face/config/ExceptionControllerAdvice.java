package com.face.config;

import com.face.exception.APIException;
import com.zero.api.exception.DubboServiceException;
import com.zero.api.util.ResultCode;
import com.zero.api.util.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author admin
 * @date 2020/8/4-14:04
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.face.controller"})
public class ExceptionControllerAdvice {

    @ExceptionHandler(APIException.class)
    public ResultDto<String> APIExceptionHandler(APIException e) {
        log.info("API 业务异常：{}", e.getMessage());
        return new ResultDto<>(ResultCode.FAILED.getCode(), e.getMsg());
    }

    @ExceptionHandler(DubboServiceException.class)
    public ResultDto<String> DubboServiceExceptionHandler(DubboServiceException e) {
        log.info("Dubbo 业务异常：{}", e.getMessage());
        return new ResultDto<>(ResultCode.FAILED.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultDto<String> UnKnowExceptionHandler(Exception e) {
        log.info("系统异常：{}", e.getMessage());
        return new ResultDto<>(ResultCode.FAILED.getCode(), "系统异常");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultDto<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<ObjectError> list = e.getBindingResult().getAllErrors();
        StringBuffer validError = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            validError.append(list.get(i).getDefaultMessage()).append(";");
        }
        log.info("参数验证不通过：{}", validError.toString());
        return new ResultDto<String>(ResultCode.VALIDATE_FAILED, validError.toString());
    }


}
