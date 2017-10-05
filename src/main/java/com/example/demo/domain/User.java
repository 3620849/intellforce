package com.example.demo.domain;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Data
@ToString
public  class User implements UserDetails {

    private int Id;
    private List<UserAuthority> authorities;
    private String last_name;
    private String password;
    private String email;
    private String phone;
    private String username;
    private TreeMap<Integer,Integer> answers;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User() {
        this.answers = new TreeMap<>();
    }

    public void grantRole(Role role) {
        if (authorities == null) {
            authorities = new ArrayList<>();
        }
        authorities.add(new UserAuthority(this,role.name()));
    }
}
