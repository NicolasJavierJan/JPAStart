package com.example.jpastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class JpaStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaStartApplication.class, args);
    }

}
