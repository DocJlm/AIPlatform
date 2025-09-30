package com.example.zqccodefatheraiplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.zqccodefatheraiplatform.mapper")
public class ZqcCodefatherAiplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqcCodefatherAiplatformApplication.class, args);
    }

}
