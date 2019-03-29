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
                RoleServiceClientFallbackFactory.LOGGER.info("fallback in findByRoleName; reason was:", throwable);
                return null;
            }

            @Override
            public ResponseEntity<Role> createRole(Role role) {
                RoleServiceClientFallbackFactory.LOGGER.info("fallback in createRole; reason was:", throwable);
                return null;
            }
        };
    }
}
