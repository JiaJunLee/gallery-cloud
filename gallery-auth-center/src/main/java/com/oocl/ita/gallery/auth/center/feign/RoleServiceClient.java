package com.oocl.ita.gallery.auth.center.feign;

import com.oocl.ita.gallery.common.model.Role;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GALLERY-ROLE-SERVICE", fallbackFactory = RoleServiceClientFallbackFactory.class)
public interface RoleServiceClient {
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    ResponseEntity<Role> findByRoleName(@RequestParam String roleName);

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    ResponseEntity<Role> createRole(Role role);
}
