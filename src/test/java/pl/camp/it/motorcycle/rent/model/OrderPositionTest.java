package pl.camp.it.motorcycle.rent.model;

import org.junit.Assert;
import org.junit.Test;

public class OrderPositionTest {

    @Test
    public void increaseOrderPositionQuantity(){

        OrderPosition orderPosition = new OrderPosition();
        orderPosition.setPositionQuantity(3);
        orderPosition.setId(1);
        orderPosition.setMotorcycle(generateMotorcycle());

        int expectedQuantity = 4;

        orderPosition.increaseQuantity();
        Assert.assertEquals(expectedQuantity, orderPosition.getPositionQuantity());

        int expectedQuantity2 = 5;

        orderPosition.increaseQuantity();
        Assert.assertEquals(expectedQuantity2, orderPosition.getPositionQuantity());

        int expectedQuantity3 = 6;

        orderPosition.increaseQuantity();
        Assert.assertEquals(expectedQuantity3, orderPosition.getPositionQuantity());

    }

    private Motorcycle generateMotorcycle() {

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setId(1);
        motorcycle.setBrand("Honda");
        motorcycle.setModel("CBR");
        motorcycle.setYear(2005);
        motorcycle.setCapasity(599);
        motorcycle.setPrice(77.77);
        motorcycle.setVin("fsdfsdfsdf54234234234");
        motorcycle.setQuantity(23589);



        return motorcycle;
    }
}
