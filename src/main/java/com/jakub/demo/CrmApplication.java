package com.jakub.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }
//
//    @Bean
//    public ActiveUserStore activeUserStore(){
//        return new ActiveUserStore();
//    }



}

