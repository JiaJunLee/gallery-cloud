package com.oocl.ita.gallery.user.service;

import com.oocl.ita.gallery.common.log.annotation.EnableRuntimeLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableRuntimeLogger
public class GalleryUserService {

  public static void main(String[] args) {
    SpringApplication.run(GalleryUserService.class, args);
  }

}
