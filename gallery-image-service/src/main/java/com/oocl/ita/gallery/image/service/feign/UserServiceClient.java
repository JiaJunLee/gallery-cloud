package com.oocl.ita.gallery.image.service.feign;

import com.oocl.ita.gallery.common.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "GALLERY-USER-SERVICE", fallbackFactory = UserServiceClientFallbackFactory.class)
public interface UserServiceClient {

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  ResponseEntity<User> getUserEntity();

}


