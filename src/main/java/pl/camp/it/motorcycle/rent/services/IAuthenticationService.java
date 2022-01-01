package pl.camp.it.motorcycle.rent.services;

import pl.camp.it.motorcycle.rent.model.view.RegisterUser;

public interface IAuthenticationService {
    void authenticate(String login, String password);

    void logout();

    boolean register(RegisterUser registerUser);

}
