package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
@Data
@AllArgsConstructor
public class UserAuthority implements GrantedAuthority {

    private User user;
    private String authority;
    @Override
    public String getAuthority() {
        return authority;
    }

}
