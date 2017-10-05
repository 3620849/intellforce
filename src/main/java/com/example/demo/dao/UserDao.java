package com.example.demo.dao;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.UserAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.TreeMap;

@Repository
public class UserDao {
    ArrayList<User> userList ;

    public UserDao() {
        userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setPassword("admin");
        user.setUsername("admin");
        user.setEmail("admin@admin");
        user.setPhone("123");
        user.setLast_name("last_name_admin");
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.grantRole(Role.ROLE_USER);
        userList.add(user);
    }
    public boolean setAnswer(User user, Answer answer){
        User u = getUserByUsername(user.getUsername());
        u.getAnswers().put(answer.getQuestionId(),answer.getAnswerId());
        return true;
    }

    public User getUserByUsername(String username) {
        for(User u:userList){
            if(u.getUsername().equals(username)){return u;}
        }
        throw new UsernameNotFoundException("USER NOT FOUND");
    }

    public User checkPass(User u, String pass){

            for(User user:userList){
                if(u.getUsername().equals(user.getUsername())){
                    if (user.getPassword().equals(pass))return user;}
            }

        throw new UsernameNotFoundException("USER NOT FOUND");
    }
    public User find(int id){
        for(User u:userList){
            if(u.getId()== id){return u;}
        }
        return null;
    }

    public Optional<User> findById(int id) {
        return Optional.ofNullable(find(id));
    }

    public int getCurrentId() {
        return userList.size();
    }

    public boolean addUser(User user) {
        try{getUserByUsername(user.getUsername());}
        catch(Exception e) {
            userList.add(user);
            return true;
        }

        return false;
    }
}
