package com.example.demo.dto;

import com.example.demo.entity.User;

public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String role;

    public User toUser() {
        User u = new User();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(password);
        return u;
    }

    public String getRole() {
        return role;
    }
}
