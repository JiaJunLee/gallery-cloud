package com.oocl.ita.gallery.file.service;

import com.oocl.ita.gallery.common.log.annotation.EnableRuntimeLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableRuntimeLogger
public class GalleryFileService {

  public static void main(String[] args) {
    SpringApplication.run(GalleryFileService.class, args);
  }

}
