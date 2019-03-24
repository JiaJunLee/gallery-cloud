package com.oocl.ita.gallery.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@EnableEurekaClient
public class ConfigClientApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class, args);
    }

    @Value("${username}")
    String userName;

    @RequestMapping(value = "/getUserName")
    public String getUserName () {
        return userName;
    }
}

