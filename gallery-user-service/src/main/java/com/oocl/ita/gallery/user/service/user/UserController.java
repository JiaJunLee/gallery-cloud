package com.oocl.ita.gallery.user.service.user;

import com.oocl.ita.gallery.common.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

  @GetMapping
  public ResponseEntity<User> test() {
    return new ResponseEntity<>(new User("GALLERY", "123456"), HttpStatus.OK);
  }

}
