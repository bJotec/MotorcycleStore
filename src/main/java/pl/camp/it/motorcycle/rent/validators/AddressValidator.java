package pl.camp.it.motorcycle.rent.validators;

import pl.camp.it.motorcycle.rent.excepions.ValidationException;

public class AddressValidator {
    public static void validateAddress(String address) {
        if(!address.matches("[A-Z][a-z]+\\ [1-9]([0-9]{0,3})?([A-Za-z]{1})?(\\/[1-9][0-9]{0,2})?")) {
            throw new ValidationException("Address incorrect");
        }
    }
    public static void validatePostalCode(String postalCode) {
            if(!postalCode.matches("[0-9]{2}-[0-9]{3}")) {
                throw new ValidationException("Kod pocztowy niepoprawny");
            }
    }
    public static void validateCity(String city) {
                                                                                //"[A-ZĄŻŹĆĘŃÓŁ][a-zążźćęńół]+(-[A-ZĄŻŹĆĘŃÓŁ][a-zążźćęńół]+)?(\\ [A-ZZĄŻŹĆĘŃÓŁ][a-zążźćęńół]+)?"
        if(!city.matches("[A-ZĄŻŹĘĆŃÓŁ][a-zóążćśńłę]+(-[A-ZĄŻŹĘĆŃÓŁ][a-zóążćśńłę]+)?(\\ [A-ZĄŻŹĘĆŃÓŁ][a-zóążćśńłę]+)?")) {
            throw new ValidationException("City incorrect");
        }
    }
    public static void validatePhone(String phone) {
        if (!phone.matches("[1-9][0-9]{8}")){
            throw new ValidationException("Telefon niepoprawny");
        }
    }
}
