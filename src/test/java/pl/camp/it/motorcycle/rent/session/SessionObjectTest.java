package pl.camp.it.motorcycle.rent.session;

import org.junit.Assert;
import org.junit.Test;
import pl.camp.it.motorcycle.rent.model.User;
import pl.camp.it.motorcycle.rent.sesion.SessionObject;

public class SessionObjectTest {

    @Test
    public void newSessionTest() {
        SessionObject sessionObject = new SessionObject();

        boolean result = sessionObject.isLogged();

        Assert.assertFalse(result);
    }

    @Test
    public void loggedUserTest() {
        SessionObject sessionObject = new SessionObject();
        sessionObject.setUser(generateUser());

        boolean result = sessionObject.isLogged();

        Assert.assertTrue(result);
    }

    private User generateUser() {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("asdf234sdf324sd5re");
        user.setMail("sdgf@dsfg.pl");
        user.setName("Janusz");
        user.setSurname("Kowalski");
        user.setId(1);

        return user;
    }
}
