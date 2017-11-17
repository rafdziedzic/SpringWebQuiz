package dziedzic.rafal.webQuiz.daoImpl;

import dziedzic.rafal.webQuiz.dao.DaoQuestion;
import dziedzic.rafal.webQuiz.model.Question;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuestionRepository implements DaoQuestion {

 private static final List<Question> LIST_QUESTION = Arrays.asList(
         new Question("Stolica Brazyli","San Paulo","Rio","Brasilla",3),
         new Question("Stolica Polski","Krakow","Warszawa","Poznan",2),
         new Question("Stolica Poladsadadi","Krakow","Warszawa","Poznan",2));


    @Override
    public List<Question> showAll() {

        return LIST_QUESTION;
    }
}
