package com.oocl.ita.gallery.file.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class GalleryFileService {

  public static void main(String[] args) {
    SpringApplication.run(GalleryFileService.class, args);
  }

}
