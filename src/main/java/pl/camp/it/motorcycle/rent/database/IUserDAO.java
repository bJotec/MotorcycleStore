package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin (String login);
    void addUser (User user);
    void removeUser(User user);

}
