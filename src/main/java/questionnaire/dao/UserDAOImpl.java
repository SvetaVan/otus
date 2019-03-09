package questionnaire.dao;

import questionnaire.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserByName(String name, String surname) {
        return new User(name, surname);
    }
}
