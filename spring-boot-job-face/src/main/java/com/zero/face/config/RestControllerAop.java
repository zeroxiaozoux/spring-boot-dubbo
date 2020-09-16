package com.zero.face.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zero.api.util.ResultDto;
import com.zero.face.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author zero
 * @date 2020/8/26-17:36
 * RequestBodyAdvice 指对参数 @RequestBody 有效
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.zero.face.controller")
public class RestControllerAop implements RequestBodyAdvice, ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        return httpInputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        RequestMapping requestMapping = methodParameter.getMethodAnnotation(RequestMapping.class);
        log.info("请求地址: {}, 请求参数: {}", StringUtils.arrayToDelimitedString(requestMapping.value(), ","), JSON.toJSONString(body, SerializerFeature.WriteMapNullValue));
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        RequestMapping requestMapping = methodParameter.getMethodAnnotation(RequestMapping.class);
        log.info("请求地址: {}", StringUtils.arrayToDelimitedString(requestMapping.value(), ","));
        return body;
    }


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
        return !returnType.getGenericParameterType().equals(ResultDto.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("返回内容: {}", JSON.toJSONString(body, SerializerFeature.WriteMapNullValue));
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVO里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new ResultDto<>(body));
            } catch (JsonProcessingException e) {
                throw new APIException("返回String类型错误");
            }
        } else {
            return new ResultDto<>(body);
        }

    }

}
