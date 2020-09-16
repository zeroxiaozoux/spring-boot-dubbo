package com.dubbo.job.config;

import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dubbo.job.task.PropertiesSimpleJob;
import com.purgeteam.elasticjob.starter.factory.SpringJobSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author zero
 * @date 2020/9/4-19:37
 */
@Configuration
public class PropertiesSimpleJobConfig {
    @Resource
    private SpringJobSchedulerFactory springJobSchedulerFactory;

    @Bean(initMethod = "init")
    public JobScheduler propertiesSimpleJobScheduler(final PropertiesSimpleJob job) {
        return springJobSchedulerFactory.getSpringJobScheduler(job,"PropertiesSimpleJob", true);
    }
}
