package com.oocl.ita.gallery.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class GalleryHystrixDashboard {

  public static void main(String[] args) {
    SpringApplication.run(GalleryHystrixDashboard.class, args);
  }

}
