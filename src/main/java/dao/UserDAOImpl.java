package dao;

import domain.User;

public class UserDAOImpl implements UserDAO {
    @Override
    public User getUserByName(String name, String surname) {
        return new User(name, surname);
    }
}
