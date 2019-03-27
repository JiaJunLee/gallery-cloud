package com.oocl.ita.gallery.user.service.user;

import com.oocl.ita.gallery.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    ResponseEntity<User> findByUserName(@PathVariable("userName") String username) {
        return new ResponseEntity<>(userService.findByUserName(username), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

}
