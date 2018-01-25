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
         new Question("Jeżeli Integer integerOne = new Integer(12345);  Integer integerTwo = new Integer(11245); Co zwróci integerOne==integerTwo ?","false","true","null",1),
         new Question("Którego z tych słów kluczowych NIE możemy użyć jako mmodyfikator dostępu do klasy","public","protected","abstract",2),
         new Question("Które z poniżej wymienionych nie jest klasyczną kolekcją","List","Map","Set",2),
         new Question("Które zdanie jest prawdziwe","Java wspiera mechanizm wielokrotnego dziedziczenia?","klasa może być jednocześnie abstract i final?","Interface może dziedziczyć po wielu interface?",3),
         new Question("Co zwraca konstruktor","pusty paramert","nic nie zwraca","to zależy od klasy",2));


    @Override
    public List<Question> showAll() {

        return LIST_QUESTION;
    }
}
