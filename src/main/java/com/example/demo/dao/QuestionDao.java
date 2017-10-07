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
        q.setImage_path("/img/qw.png");
        q.setQuestion("how are you?");
        q.setAnswers(new String[]{"Fine(Correct)","Bad","So so","Awful"});
        q.setCorrectAnswer(1);
        questionList.add(q);
        Question q2 = new Question();
        q2.setId(2);
        q2.setImage_path("/img/qw2.png");
        q2.setQuestion("What time is it?");
        q2.setAnswers(new String[]{"12:00","Time to survey(Correct)","13:00"});
        q2.setCorrectAnswer(2);
        questionList.add(q2);
        Question q3 = new Question();
        q3.setId(3);
        q3.setImage_path("/img/qw3.png");
        q3.setQuestion("What do you see on image?");
        q3.setAnswers(new String[]{"Time","Nothing","Question char(Correct)","My future"});
        q3.setCorrectAnswer(3);
        questionList.add(q3);
        Question q4 = new Question();
        q4.setId(4);
        q4.setImage_path("/img/qw4.png");
        q4.setQuestion("Who are you?");
        q4.setAnswers(new String[]{"I","You","Me","I'm BATMAN!(Correct)"});
        q4.setCorrectAnswer(4);
        questionList.add(q4);
        Question q5 = new Question();
        q5.setId(5);
        q5.setImage_path("/img/qw5.png");
        q5.setQuestion("How old are you?");
        q5.setAnswers(new String[]{"0-5","5-18","18-25","25-100","I'm to young for all this(Correct)"});
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
