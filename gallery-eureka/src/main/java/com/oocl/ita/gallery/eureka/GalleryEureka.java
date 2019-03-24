package com.oocl.ita.gallery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GalleryEureka {

  public static void main(String[] args) {
    SpringApplication.run(GalleryEureka.class, args);
  }

}
