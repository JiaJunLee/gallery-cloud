package com.oocl.ita.gallery.user.service.user;

import com.oocl.ita.gallery.common.model.BaseService;
import com.oocl.ita.gallery.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService extends BaseService<User, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public PagingAndSortingRepository<User, String> getRepository() {
        return this.userRepository;
    }

    public List<User> findAllByType(String type) {
        return userRepository.findAllByType(type);
    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            user.setRoles(Arrays.asList("ROLE_USER"));
            this.save(user);
        } else {
            throw new RuntimeException("error");
        }
        return user;
    }


}

