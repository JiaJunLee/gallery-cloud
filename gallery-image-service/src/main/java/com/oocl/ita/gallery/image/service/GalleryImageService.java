package com.oocl.ita.gallery.image.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class GalleryImageService {

  public static void main(String[] args) {
    SpringApplication.run(GalleryImageService.class, args);
  }

}
