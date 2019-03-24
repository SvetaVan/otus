package questionnaire.dao;

import questionnaire.domain.User;

public interface UserDAO {

 User getUserByName(String name, String surname);


}
