package com.oocl.ita.gallery.image.service.image;

import com.oocl.ita.gallery.common.model.User;
import com.oocl.ita.gallery.image.service.feign.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/images")
public class ImageController {

  @Autowired
  private UserServiceClient userServiceClient;

  @GetMapping
  public ResponseEntity<User> test() {
    return this.userServiceClient.getUserEntity();
  }

}
