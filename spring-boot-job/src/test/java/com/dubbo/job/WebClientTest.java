package com.dubbo.job;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zero
 * @date 2020/9/14-17:42
 */
public class WebClientTest {
    public static void main(String[] args) {
        Map<String, String> urlParam = new HashMap<>();
        urlParam.put("sex", "男");
        WebClientUtil.webClientGet("http://192.168.1.116:8051/stat/get", urlParam);
//       String str  = WebClientUtil.mapToString(urlParam);
//        System.out.println("------------------"+str);
    }
}
