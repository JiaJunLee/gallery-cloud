package com.oocl.ita.gallery.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class GalleryTurbine {

  public static void main(String[] args) {
    SpringApplication.run(GalleryTurbine.class, args);
  }

}
