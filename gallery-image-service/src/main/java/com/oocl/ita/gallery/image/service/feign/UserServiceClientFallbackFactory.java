package com.oocl.ita.gallery.image.service.feign;

import com.oocl.ita.gallery.common.model.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceClientFallbackFactory implements FallbackFactory<UserServiceClient> {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceClientFallbackFactory.class);

  @Override
  public UserServiceClient create(Throwable throwable) {
    return new UserServiceClient() {
      @Override
      public ResponseEntity<User> getUserEntity() {
        LOGGER.error("UserServiceClient - getUserEntity service is unavailable", throwable);
        return new ResponseEntity<>(new User(), HttpStatus.OK);
      }
    };
  }

}