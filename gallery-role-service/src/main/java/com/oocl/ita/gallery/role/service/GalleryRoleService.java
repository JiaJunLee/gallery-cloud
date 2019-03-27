package com.oocl.ita.gallery.role.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class GalleryRoleService {
    public static void main(String[] args) {
        SpringApplication.run(GalleryRoleService.class, args);
    }
}
