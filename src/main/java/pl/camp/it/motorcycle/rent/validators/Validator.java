package pl.camp.it.motorcycle.rent.validators;

import pl.camp.it.motorcycle.rent.excepions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validateLogin(String login) {                        
            if(!login.matches(".{3}.*")) {
                throw new ValidationException("Login jest za krótki");
            }
    }
    public static void validatePassword(String password) {
        if(!password.matches(".{3}.*" )) {
            throw new ValidationException("Hasło jest za krótkie");
        }
    }
    public static void validateName(String name) {
         basicValidaction(name);
    }
    public static void validateSurname(String surname) {
        basicValidaction(surname);
    }
    public static void validateMail(String mail) {
        Pattern pattern = Pattern.compile(".+@.+\\.[a-z]{2,3}");    // inny sposob tworzenia wzorców
        Matcher matcher = pattern.matcher(mail);
        if (!matcher.matches()) {
            throw new ValidationException("Niepoprawny mail");
        }
    }


    public static void basicValidaction(String value) {
        if(!value.matches("[A-Z][a-z]+")){
            throw new ValidationException("value incorrect");
        }
    }
    public static void passwordChecked(String password, String password2) {
        if (!password.equals(password2)) {
            throw new ValidationException("Hasła są różne");
        }
    }
}
