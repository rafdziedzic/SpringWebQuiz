package dziedzic.rafal.webQuiz.dao;

import dziedzic.rafal.webQuiz.model.User;

import java.util.List;

public interface DaoUser {
    void addUser(User user);

    List<User> showAll();

    User find(int id);
}
