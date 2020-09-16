package com.face;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.face.*"})
public class FaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceApplication.class, args);
    }

}
