package com.example.demo.dto;

public class AuthRequest {

    private String usernameOrEmail;
    private String password;

    public AuthRequest() {
    }

    // Getter and Setter methods

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
