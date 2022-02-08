package pl.camp.it.motorcycle.rent.model;

import org.junit.Assert;
import org.junit.Test;

public class OrderTest {

    @Test
    public void standardOrderTest() {
        Order order = new Order();
        order.setId(1);
        order.setStatus(Order.Status.NEW);
        order.setUser(generateUser());
        order.setAddress(generateAddress());

        order.getOrderPositions().add(generateOrderPosition(1, 100.01));
        order.getOrderPositions().add(generateOrderPosition(2, 200.01));
        order.getOrderPositions().add(generateOrderPosition(3, 300.01));

        double expectedResult = 1400.06;

        double result = order.calculateSum();

        Assert.assertEquals(expectedResult, result, 0.001);
    }

    @Test
    public void emptyOrderTest() {
        Order order = new Order();
        order.setId(1);
        order.setStatus(Order.Status.NEW);
        order.setUser(generateUser());
        order.setAddress(generateAddress());


        double expectedResult = 0.0;

        double result = order.calculateSum();

        Assert.assertEquals(expectedResult,result,0.001);
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

    private Address generateAddress() {
        Address address = new Address();
        address.setAddress("Ogrodowa 12/4");
        address.setPhone("123123123");
        address.setCity("Kraków");
        address.setPostalCode("12-123");
        address.setSurname("Kowalski");
        address.setName("Janusz");
        address.setId(1);

        return address;
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
