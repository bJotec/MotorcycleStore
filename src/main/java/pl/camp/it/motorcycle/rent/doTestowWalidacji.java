package pl.camp.it.motorcycle.rent;

import pl.camp.it.motorcycle.rent.validators.AddressValidator;

public class doTestowWalidacji {
    public static void main(String[] args) {
        AddressValidator.validateAddress("Czerwona 123");
        AddressValidator.validatePostalCode("44-688");
        AddressValidator.validateCity("Gaadarrr");
        AddressValidator.validatePhone("888999777");
    }
}
