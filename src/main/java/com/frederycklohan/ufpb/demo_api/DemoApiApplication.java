package com.frederycklohan.ufpb.demo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;


@SpringBootApplication
public class DemoApiApplication {


    @Bean
    public ModelMap modelMap(){
        return new ModelMap();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }

}
