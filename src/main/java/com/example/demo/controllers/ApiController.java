package com.example.demo.controllers;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.domain.User;
import com.example.demo.domain.UserStatistic;
import com.example.demo.services.QuestionService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestionById (@PathVariable("id") int id){
        return new ResponseEntity<>( questionService.getQuestionById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public boolean setAnswer (@RequestBody Answer answer){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        try{userService.setAnswer(user,answer);}catch (Exception e){
            return false;
        }
        return true;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or principal.username == #username")
    @RequestMapping(value = "/getUserInfo/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserStatistic> getUserInfo (@PathVariable("username") String username){
        return new ResponseEntity<>(userService.getUserInfo(username), HttpStatus.OK);
    }
}
