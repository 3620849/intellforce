package com.example.demo.controllers;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by UA C on 05.10.2017.
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        user.setId(userService.generateId());
        user.setAccountNonLocked(true);
        user.grantRole(Role.ROLE_USER);
        user.setEnabled(true);
        try {return userService.addUser(user);}catch (Exception e){
            return false;
        }
    }

}
