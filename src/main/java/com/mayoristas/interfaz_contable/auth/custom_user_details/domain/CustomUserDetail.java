package com.mayoristas.interfaz_contable.auth.custom_user_details.domain;

import java.util.List;

public class CustomUserDetail {
    private String username;
    private String password;
    private List<Role> roles;

    public CustomUserDetail(String username, String password, List<Role> role) {
        this.username = username;
        this.password = password;
        this.roles = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "CustomUserDetail{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
