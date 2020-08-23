package com.goodix.hi.bigdata.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.goodix.hi.bigdata.system.mapper")
@SpringBootApplication
public class HiBigdataSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiBigdataSystemApplication.class, args);
    }

}
