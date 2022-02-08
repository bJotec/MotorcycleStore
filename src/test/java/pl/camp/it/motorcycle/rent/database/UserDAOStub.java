package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.User;

import java.util.Optional;

public class UserDAOStub implements IUserDAO{
    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }
}
