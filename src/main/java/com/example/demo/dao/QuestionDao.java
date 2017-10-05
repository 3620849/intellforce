package com.example.demo.dao;

import com.example.demo.domain.Question;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class QuestionDao {
    ArrayList<Question> questionList ;

    public QuestionDao( ) {
        this.questionList = new ArrayList<>();
        Question q = new Question();
        q.setId(1);
        q.setImage_path("/lib/img1.img");
        q.setQuestion("how are you?");
        q.setAnswers(new String[]{"a","b","c","d"});
        q.setCorrectAnswer(1);
        questionList.add(q);
        Question q2 = new Question();
        q2.setId(2);
        q2.setImage_path("/lib/img2.img");
        q2.setQuestion("What time is it?");
        q2.setAnswers(new String[]{"a","b","c","d"});
        q2.setCorrectAnswer(2);
        questionList.add(q2);
        Question q3 = new Question();
        q3.setId(3);
        q3.setImage_path("/lib/img3.img");
        q3.setQuestion("What is your name?");
        q3.setAnswers(new String[]{"a","b","c","d"});
        q3.setCorrectAnswer(3);
        questionList.add(q3);
        Question q4 = new Question();
        q4.setId(4);
        q4.setImage_path("/lib/img4.img");
        q4.setQuestion("What is your family?");
        q4.setAnswers(new String[]{"a","b","c","d"});
        q4.setCorrectAnswer(4);
        questionList.add(q4);
        Question q5 = new Question();
        q5.setId(5);
        q5.setImage_path("/lib/img5.img");
        q5.setQuestion("How old are you?");
        q5.setAnswers(new String[]{"a","b","c","d"});
        q5.setCorrectAnswer(5);
        questionList.add(q5);
    }

    public Question getQuestionById(int id) {
        try{return questionList.get(id-1);}
        catch (Exception e){
            throw new AccessDeniedException("No Access");
        }
    }
    public int getRightAnswer(int i){
      try{ return questionList.get(i-1).getCorrectAnswer();}
      catch (Exception e){
          return -1;
      }
    }
}
