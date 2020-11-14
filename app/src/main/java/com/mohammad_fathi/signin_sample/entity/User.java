package com.mohammad_fathi.signin_sample.entity;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;

    public User(int id, String name, String username, String password , String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {        return email;    }

    public void setEmail(String email) {        this.email = email;    }
}
