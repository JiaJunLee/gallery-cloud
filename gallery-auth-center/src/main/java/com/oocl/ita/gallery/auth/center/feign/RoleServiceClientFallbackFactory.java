package com.oocl.ita.gallery.auth.center.feign;

import com.oocl.ita.gallery.common.model.Role;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceClientFallbackFactory implements FallbackFactory<RoleServiceClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceClientFallbackFactory.class);
    @Override
    public RoleServiceClient create(Throwable throwable) {
        return new RoleServiceClient() {
            @Override
            public ResponseEntity<Role> findByRoleName(String roleName) {
                return null;
            }

            @Override
            public ResponseEntity<Role> createRole(Role role) {
                return null;
            }
        };
    }
}
