package com.dubbo.job.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * @author zero
 * @date 2020/9/14-15:00
 */
@Data
@ConfigurationProperties(prefix = "rest.url")
@PropertySource(value = "{classpath:/application-${spring.profiles.active}.properties}", ignoreResourceNotFound = true, encoding = "utf-8")
@Configuration
public class RestUrlConfig {
    private String base;
    private Map<String,String> service;


}
