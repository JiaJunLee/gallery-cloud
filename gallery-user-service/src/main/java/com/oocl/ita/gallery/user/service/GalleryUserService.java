package com.oocl.ita.gallery.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class GalleryUserService {

  public static void main(String[] args) {
    SpringApplication.run(GalleryUserService.class, args);
  }

}
