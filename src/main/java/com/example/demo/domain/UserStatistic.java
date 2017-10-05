package com.example.demo.domain;

import lombok.Data;

/**
 * Created by UA C on 05.10.2017.
 */
@Data
public class UserStatistic {
    String username;
    boolean question1 = false;
    boolean question2 = false;
    boolean question3 = false;
    boolean question4 = false;
    boolean question5 = false;
}
