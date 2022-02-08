package pl.camp.it.motorcycle.rent.validators;

import org.junit.Test;
import pl.camp.it.motorcycle.rent.excepions.ValidationException;

public class AddressValidatorTest {

    @Test(expected = ValidationException.class)
    public void streetNameLowerCaseTest() {
        String address = "niebieska 44";
        AddressValidator.validateAddress(address);
    }

    @Test(expected = ValidationException.class)
    public void noBuildingNumberTest() {
        String address = "Niebieska";
        AddressValidator.validateAddress(address);
    }

    @Test
    public void threeDigitBuildingNumberTest() {
        String address = "Czerwona 123";
        AddressValidator.validateAddress(address);
    }

    @Test(expected = ValidationException.class)
    public void tooLongBuildingNumberTest() {
        String address = "Czerwona 123456";
        AddressValidator.validateAddress(address);
    }

    @Test(expected = ValidationException.class)
    public void twoLettersInBuildingNumberTest() {
        String address = "Czerwona 12AB";
        AddressValidator.validateAddress(address);
    }

    @Test(expected = ValidationException.class)
    public void incorrectFlatNumberSeparatorTest() {
        String address = "Czerwona 12,6";
        AddressValidator.validateAddress(address);
    }

    @Test(expected = ValidationException.class)
    public void tooLongFlatNumberTest() {
        String address = "Czerwona 12/12345";
        AddressValidator.validateAddress(address);
    }

    @Test
    public void correctAddressTest() {
        String address = "Czerwona 12A/5";
        AddressValidator.validateAddress(address);
    }

    @Test(expected = ValidationException.class)
    public void tooManyDigitsFirstPartPostalCodeTest() {
        String code = "123-123";
        AddressValidator.validatePostalCode(code);
    }

    @Test(expected = ValidationException.class)
    public void notEnoughDigitsFirstPartPostalCodeTest() {
        String code = "1-123";
        AddressValidator.validatePostalCode(code);
    }

    @Test(expected = ValidationException.class)
    public void incorrectSeparatorPostalCodeTest() {
        String code = "12+123";
        AddressValidator.validatePostalCode(code);
    }

    @Test(expected = ValidationException.class)
    public void tooManyDigitsSecondPartPostalCodeTest() {
        String code = "12-12334";
        AddressValidator.validatePostalCode(code);
    }

    @Test(expected = ValidationException.class)
    public void notEnoughDigitsSecondPartPostalCodeTest() {
        String code = "1-13";
        AddressValidator.validatePostalCode(code);
    }

    @Test
    public void correctPostalCodeTest() {
        String code = "12-123";
        AddressValidator.validatePostalCode(code);
    }

    @Test(expected = ValidationException.class)
    public void firstLowerCaseCityTest() {
        String city = "dobron";
        AddressValidator.validateCity(city);
    }

    @Test(expected = ValidationException.class)
    public void incorrectSpaceSeparatorTest() {
        String city = "Dobron*Maly";
        AddressValidator.validateCity(city);
    }

    @Test(expected = ValidationException.class)
    public void secondPartLowerCaseTest() {
        String city = "Dobron Maly";
        AddressValidator.validateCity(city);
    }

    @Test(expected = ValidationException.class)
    public void secondPartLowerCase2Test() {
        String city = "Dobron maly";
        AddressValidator.validateCity(city);
    }

    @Test
    public void correctCityTest() {
        String city1 = "Dobroń";
        String city2 = "Dobron Mały";
        String city3 = "Dobron-Mały";
        String city4 = "Dobron-Maly Cosss";
        AddressValidator.validateCity(city1);
        AddressValidator.validateCity(city2);
        AddressValidator.validateCity(city3);
        AddressValidator.validateCity(city4);
    }

    @Test(expected = ValidationException.class)
    public void firstZeroPhoneNumber() {
        String phone = "012345678";
        AddressValidator.validatePhone(phone);
    }

    @Test(expected = ValidationException.class)
    public void notEnoughDigitsPhoneTest() {
        String phone = "3123456";
        AddressValidator.validatePhone(phone);
    }

    @Test
    public void correctPhoneTest() {
        String phone = "123123123";
        AddressValidator.validatePhone(phone);
    }

}
