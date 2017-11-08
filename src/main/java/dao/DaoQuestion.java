package dao;

import model.Question;

import java.util.List;

public interface DaoQuestion {

    void addQuestion(Question question);

    List<Question> showAll();
}
