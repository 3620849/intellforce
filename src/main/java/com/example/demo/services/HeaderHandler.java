package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by UA C on 05.10.2017.
 */
@Component
public class HeaderHandler {
    @Autowired
    UserDao userDao;
    public Optional<User> extractUserName(@NonNull String header) {
        try {
            String [] arr =  header.split(":");
            return Optional.of(userDao.checkPass(userDao.getUserByUsername(arr[0]),arr[1]));

        }catch (Exception e ){
            return Optional.empty();
        }
    }
}
