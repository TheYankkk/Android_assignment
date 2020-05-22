package com.example.justeat;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String password_confirm;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;

    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getPassword_confirm() {
        return password_confirm;
    }
    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }



    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + "]";
    }

}

