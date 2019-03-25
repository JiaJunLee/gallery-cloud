package com.oocl.ita.gallery.auth.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthCenterApp.class,args);
    }
}
