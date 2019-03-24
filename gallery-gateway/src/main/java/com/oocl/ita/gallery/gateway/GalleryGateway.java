package com.oocl.ita.gallery.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GalleryGateway {

  public static void main(String[] args) {
    SpringApplication.run(GalleryGateway.class, args);
  }

}
