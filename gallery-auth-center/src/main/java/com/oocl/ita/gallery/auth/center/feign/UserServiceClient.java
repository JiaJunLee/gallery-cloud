package com.oocl.ita.gallery.auth.center.feign;

import com.oocl.ita.gallery.common.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GALLERY-USER-SERVICE", fallbackFactory = UserServiceClientFallbackFactory.class)
public interface UserServiceClient {

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  ResponseEntity<User> findByUserName(@RequestParam String username);

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  ResponseEntity<User> createUser(User user);
}


