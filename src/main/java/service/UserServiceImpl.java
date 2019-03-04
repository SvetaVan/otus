package service;

import dao.UserDAO;
import domain.User;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User identifyUser(String name, String surname) {
        return userDAO.getUserByName(name, surname);
    }



}
