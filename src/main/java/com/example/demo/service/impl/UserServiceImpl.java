package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(
            UserRepository userRepo,
            RoleRepository roleRepo,
            PasswordEncoder encoder) {
    }

    public User registerUser(User user, String roleName) {
        return user;
    }

    public User findByUsername(String username) {
        return null;
    }
}
