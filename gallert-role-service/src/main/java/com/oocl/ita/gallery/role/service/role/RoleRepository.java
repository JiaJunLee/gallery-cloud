package com.oocl.ita.gallery.role.service.role;

import com.oocl.ita.gallery.common.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, String> {
    Role findByName(String name);
}
