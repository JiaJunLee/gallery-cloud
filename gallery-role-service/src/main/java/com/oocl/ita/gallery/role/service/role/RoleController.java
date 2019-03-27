package com.oocl.ita.gallery.role.service.role;

import com.oocl.ita.gallery.common.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{roleName}")
    ResponseEntity<Role> findByRoleName(@PathVariable("roleName") String roleName) {
        return new ResponseEntity<Role>(roleService.findByRoleName(roleName), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Role> createRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
}
