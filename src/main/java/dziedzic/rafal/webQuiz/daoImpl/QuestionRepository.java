package dziedzic.rafal.webQuiz.daoImpl;

import dziedzic.rafal.webQuiz.dao.DaoQuestion;
import dziedzic.rafal.webQuiz.model.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepository implements DaoQuestion {

    List<Question> listQuestion = new ArrayList<>();

    @Override
    public void addQuestion(Question question) {
        listQuestion.add(question);
    }

    @Override
    public List<Question> showAll() {

        return listQuestion;
    }
}
