package com.zero.api.util;

import com.google.common.base.Joiner;
import com.google.gson.Gson;
import com.zero.api.ret.UserRet;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * @author zero
 * @date 2020/9/10-17:45
 */
@Slf4j
public class WebClientUtil {

    public static String webClientGet(String baseurl, Map<String, String> urlParam) {
        String uri = baseurl+"?"+mapToString(urlParam);
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient
                .get() // GET 请求
                .uri(uri) // 请求路径
                //.accept(APPLICATION_JSON)
                .retrieve() // 获取响应体
                .bodyToMono(String.class); //响应数据类型转换
        String ret = mono.block();
        log.info("webClientGet****result:{}", ret);
        return ret;
    }

    public static String mapToString(Map<String, String> urlParam) {
        return Joiner.on("&").withKeyValueSeparator("=").join(urlParam);
    }



    public static <T> String webClientPost(String baseurl, T data,Class clazz) {

        Mono<String> resp = WebClient.create().post()
                .uri(baseurl)
                .contentType(APPLICATION_JSON)
                //.body(BodyInserters.fromFormData(formData))
                .body(Mono.just(data), clazz)
                .retrieve().bodyToMono(String.class);
         String ret = resp.block();
        log.info("webClientPost****result:{}",  ret);
        return ret;
    }

    public static <T> T jsonStringToBean(String string,Class clazz){
          Gson gson = new Gson();
         return (T) gson.fromJson(string,  clazz);//对于javabean直接给出class实例
    }

    public  static <T> T resultDtojsonStringToBean(String string,Class clazz){
        Gson gson = new Gson();
        ResultDto resultDto = gson.fromJson(string,  ResultDto.class);
        if(!(ResultCode.SUCCESS.getCode() == resultDto.getCode())){
            return null;
        }
       return WebClientUtil.jsonStringToBean(resultDto.getData().toString(),clazz);
    }

    public static void main(String[] args) {
        String string = "{\"code\":1000,\"msg\":\"操作成功\",\"data\":{\"name\":\"一帆风顺ffff\",\"sex\":\"男\",\"age\":12,\"email\":\"123xdd@qq.com\"}}";
        ResultDto dto =  WebClientUtil.jsonStringToBean(string, ResultDto.class);
        System.out.println(ReflectionToStringBuilder.toString(dto));
        UserRet ret =  WebClientUtil.jsonStringToBean(dto.getData().toString(),UserRet.class);
        System.out.println(ReflectionToStringBuilder.toString(ret));
    }

}
