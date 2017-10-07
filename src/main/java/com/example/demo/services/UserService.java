package com.example.demo.services;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.Answer;
import com.example.demo.domain.Question;
import com.example.demo.domain.User;
import com.example.demo.domain.UserStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserDao userDao;
    @Autowired
    QuestionDao questionDao;
    public int generateId(){
        return userDao.getCurrentId()+1;
    };

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByUsername(username);
    }

    public  Optional<User> findById(int id) {
        return userDao.findById(id);
    }


    public void setAnswer(User user, Answer answer) {
        userDao.setAnswer( user,  answer);
    }

    public UserStatistic getUserInfo(String username) {
        int id = userDao.getUserByUsername(username).getId();
        UserStatistic userStatistic = new UserStatistic();
        userStatistic.setUsername(userDao.find(id).getUsername());
        userStatistic.setQuestion1(isRight(1,id));
        userStatistic.setQuestion2(isRight(2,id));
        userStatistic.setQuestion3(isRight(3,id));
        userStatistic.setQuestion4(isRight(4,id));
        userStatistic.setQuestion5(isRight(5,id));
        return userStatistic;
    }

    private boolean isRight(int question , int userId) {
        try {
            return questionDao.getRightAnswer(question)==userDao.find(userId).getAnswers().get(question);
        }catch (Exception e){
            return false;
        }
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
}
