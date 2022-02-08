package pl.camp.it.motorcycle.rent.model;

import org.junit.Assert;
import org.junit.Test;

public class CartTest {

    @Test
    public void standardCartSum() {

        Cart cart = new Cart();
        cart.getPositions().add(generateOrderPosition(1, 100.01));
        cart.getPositions().add(generateOrderPosition(2, 200.01));
        cart.getPositions().add(generateOrderPosition(3, 300.01));
        double expectedResult = 1400.06;
        double result = cart.calculateSum();
        Assert.assertEquals(expectedResult, result, 0.001);

    }

    @Test
    public void emptyCartTest() {
        Cart cart = new Cart();
        double expectedResult = 0.0;
        double result = cart.calculateSum();
        Assert.assertEquals(expectedResult, result, 0.001);
    }


    private OrderPosition generateOrderPosition(int quantity, double price) {

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setId(1);
        motorcycle.setBrand("Honda");
        motorcycle.setModel("CBR");
        motorcycle.setYear(2005);
        motorcycle.setCapasity(599);
        motorcycle.setPrice(price);
        motorcycle.setVin("fsdfsdfsdf54234234234");
        motorcycle.setQuantity(23589);

        OrderPosition orderPosition = new OrderPosition();
        orderPosition.setId(1);
        orderPosition.setPositionQuantity(quantity);

        orderPosition.setMotorcycle(motorcycle);

        return orderPosition;
    }
}
