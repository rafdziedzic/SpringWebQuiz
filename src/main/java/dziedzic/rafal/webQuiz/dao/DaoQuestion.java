package dziedzic.rafal.webQuiz.dao;

import dziedzic.rafal.webQuiz.model.Question;

import java.util.List;

public interface DaoQuestion {

    void addQuestion(Question question);

    List<Question> showAll();
}
