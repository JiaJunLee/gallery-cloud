package com.oocl.ita.gallery.user.service.user;

import com.oocl.ita.gallery.common.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;


public class UserServiceTest {

    @InjectMocks
    private UserService userService = new UserService();

    @Mock
    private UserRepository userRepository;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(userRepository.findByUsername(Mockito.eq("b"))).thenReturn(new User());
        Mockito.when(userRepository.findByUsername(Mockito.eq("a"))).thenReturn(null);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        Mockito.when(userRepository.findAllByType(Mockito.eq("admin"))).thenReturn(users);
    }

    @Test
    public void should_return_userRepository_when_getRepository() {
        //When
        PagingAndSortingRepository<User, String> repository = userService.getRepository();

        //Then
        Assert.assertNotNull(repository);
    }

    @Test
    public void should_return_user_not_null_when_findByUserName_given_name_b() {
        //Given
        String username = "b";

        //When
        User b = userService.findByUserName("b");

        //Then
        Assert.assertNotNull(b);
    }


    @Test
    public void should_return_user_size_2_when_findAllByType_given_name_admin() {
        //Given
        String admin = "admin";

        //When
        List<User> b = userService.findAllByType(admin);

        //Then
        Assert.assertNotNull(b);
        Assert.assertEquals(2, b.size());
    }

    @Test
    public void should_return_user_when_createUser_given_name_a() {
        //Given
        User u = new User();
        u.setUsername("a");

        //When
        User user = userService.createUser(u);

        //Then
        Assert.assertNotNull(user);
    }

    @Test(expected = Exception.class)
    public void should_catch_exception_user_when_createUser_given_name_b() {
        //Given
        User u = new User();
        u.setUsername("b");

        //When
        User user = userService.createUser(u);
    }



}