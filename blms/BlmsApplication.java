package com.ysj.blms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ysj.blms.mapper" )
public class BlmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlmsApplication.class, args);
    }

}
