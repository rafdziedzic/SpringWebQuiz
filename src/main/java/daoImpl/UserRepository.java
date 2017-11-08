package daoImpl;

import dao.DaoUser;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements DaoUser {

    List<User> listUser = new ArrayList<>();

    @Override
    public void addUser(User user) {
        listUser.add(user);
    }

    @Override
    public List<User> showAll() {
        return listUser;
    }

    @Override
    public User find(int id) {
        for (User user :listUser) {
            if(user.getId()==id) {
                return user;
            }
        }
        return null;
    }

}
