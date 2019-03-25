package com.oocl.ita.gallery.user.service.user;

import com.oocl.ita.gallery.common.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface UserRepository extends PagingAndSortingRepository<User, String> {

    User findByUsername(String username);

    List<User> findAllByType(String type);

}
