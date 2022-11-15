package com.gft.exfjavatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gft.exfjavatest.Controller","com.gft.exfjavatest.Service"})
public class ExfjavatestApplication  {


    public static void main(String[] args) {
        SpringApplication.run(ExfjavatestApplication.class, args);
    }

}
