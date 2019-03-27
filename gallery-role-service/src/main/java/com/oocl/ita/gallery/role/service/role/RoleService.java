package com.oocl.ita.gallery.role.service.role;

import com.oocl.ita.gallery.common.model.BaseService;
import com.oocl.ita.gallery.common.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role, String> {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public PagingAndSortingRepository<Role, String> getRepository() {
        return this.roleRepository;
    }

    public Role createRole(Role role) {
        if (roleRepository.findByName(role.getName()) == null) {
            this.save(role);
        } else {
            throw new RuntimeException("error");
        }
        return role;
    }

    public Role findByRoleName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
