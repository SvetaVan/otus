package questionnaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionnaire.dao.UserDAO;
import questionnaire.domain.User;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User identifyUser(String name, String surname) {
        return userDAO.getUserByName(name, surname);
    }



}
