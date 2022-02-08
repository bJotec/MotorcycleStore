package pl.camp.it.motorcycle.rent.database.impl.memory;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.motorcycle.rent.database.IUserDAO;
import pl.camp.it.motorcycle.rent.model.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDatabase implements IUserDAO {
    private final List<User> users = new ArrayList<>();


    public UserDatabase() {
        this.users.add(new User(1,"Piotr", "Kowalski", "admin", DigestUtils.md5Hex("admin"), "pkowalski@gmail.com"));
        this.users.add(new User(2,"Stefan", "Jurek", "stefan", DigestUtils.md5Hex("stefan"), "sjurek@interia.pl"));
    }

    @Override
    public Optional<User> getUserByLogin (String login) {
        for (User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void addUser (User user){
        this.users.add(user);
    }

    @Override
    public void removeUser(User user) {
        throw new NotImplementedException();
    }
}
