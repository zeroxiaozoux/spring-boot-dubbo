package com.job.springbootjobserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.zero.core.job.service"})
@MapperScan("com.zero.core.dao")
public class SpringBootJobServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJobServerApplication.class, args);
    }

}
