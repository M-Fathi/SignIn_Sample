package com.mohammad_fathi.signin_sample.entity;

public class LoginRequestDto {

    public String usernameOrEmailAddress;
    public String password;

    public LoginRequestDto(String username, String password) {
        this.usernameOrEmailAddress = username;
        this.password = password;
    }
}
