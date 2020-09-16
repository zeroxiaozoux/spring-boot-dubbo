package com.dubbo.job.utils;

import com.dubbo.job.config.RestUrlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zero
 * @date 2020/9/15-17:21
 */
@Slf4j
@Component
public class RestUrlUntils {
    @Autowired
    private RestUrlConfig restUrlConfig;

    public String getServiceUrl(String serviceKey) {
        String serviceUrl = restUrlConfig.getBase() + restUrlConfig.getService().get(serviceKey);
        //log.info("访问路径:{},访问参数：{}", serviceUrl,param);
        return serviceUrl;
    }

}
