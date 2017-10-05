package com.example.demo.services;

import com.example.demo.dao.QuestionDao;
import com.example.demo.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by UA C on 05.10.2017.
 */
@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public Question getQuestionById(int id) {
        return questionDao.getQuestionById(id);
    }
}
