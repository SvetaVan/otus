package dao;

import domain.User;

public interface UserDAO {

 User getUserByName(String name, String surname);


}
