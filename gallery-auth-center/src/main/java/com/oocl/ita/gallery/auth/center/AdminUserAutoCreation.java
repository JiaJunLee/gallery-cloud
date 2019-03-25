package com.oocl.ita.gallery.auth.center;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.oocl.ita.gallery.auth.center.feign.RoleServiceClient;
import com.oocl.ita.gallery.auth.center.feign.UserServiceClient;
import com.oocl.ita.gallery.common.model.Role;
import com.oocl.ita.gallery.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Component
class AdminUserAutoCreation implements CommandLineRunner {

    @Autowired
    private UserServiceClient userService;
    @Autowired
    private RoleServiceClient roleService;

    @Override
    public void run(String... args) {
        String userFileName = "users.json";
        String roleFileName = "roles.json";

        try {
            InputStream userInputStream = getClass().getClassLoader().getResourceAsStream(userFileName);
            if(userInputStream == null){
                throw new Exception("initialzation user file not found: " + userFileName);
            }

            InputStream roleInputStream = getClass().getClassLoader().getResourceAsStream(roleFileName);
            if(roleInputStream == null){
                throw new Exception("initialzation role file not found: " + roleFileName);
            }

            //导入初始的系统超级管理员角色
            Type roleTokenType = new TypeToken<ArrayList<Role>>(){}.getType();
            ArrayList<Role> roles = new GsonBuilder().create().fromJson(new InputStreamReader(roleInputStream, StandardCharsets.UTF_8), roleTokenType);
            for (Role role: roles) {
                if (roleService.findByRoleName(role.getName()) == null) {
                    roleService.createRole(role);
                }
            }

            //导入初始的系统管理员用户
            Type adminTypeToken = new TypeToken<ArrayList<User>>(){}.getType();
            ArrayList<User> users = new GsonBuilder().create().fromJson(new InputStreamReader(userInputStream, StandardCharsets.UTF_8), adminTypeToken);
            for (User user : users) {
                userService.createUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}