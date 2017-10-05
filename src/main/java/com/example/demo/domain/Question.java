package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by UA C on 05.10.2017.
 */
@Data
public class Question {
    int id;
    String question;
    String image_path;
    String [] answers;
    @JsonIgnore
    int correctAnswer;
}
