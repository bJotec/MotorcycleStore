package pl.camp.it.motorcycle.rent.services.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.it.motorcycle.rent.configuration.AppConfiguration;
import pl.camp.it.motorcycle.rent.configuration.TestConfiguration;
import pl.camp.it.motorcycle.rent.database.MotorcycleDAOStub;
import pl.camp.it.motorcycle.rent.database.OrderDAOStub;
import pl.camp.it.motorcycle.rent.model.Address;
import pl.camp.it.motorcycle.rent.model.Motorcycle;
import pl.camp.it.motorcycle.rent.model.OrderPosition;
import pl.camp.it.motorcycle.rent.services.IOrderService;
import pl.camp.it.motorcycle.rent.sesion.SessionObject;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class OrderServiceTest {

    @Autowired
    IOrderService orderService;

    @Resource
    SessionObject sessionObject;

    @Autowired
    OrderDAOStub orderDAO;

    @Autowired
    MotorcycleDAOStub motorcycleDAO;

    @Test
    public void confirmOrderWithNotExistingMotorcycleInCartTest() {

        this.orderDAO.setAddOrderFlag(false);

        this.sessionObject.getCart().getPositions().clear();
        Assert.assertEquals(0,this.sessionObject.getCart().getPositions().size());

        this.sessionObject.getCart().getPositions().add(generateOrderPosition("VINVINVINVIN",10));

        this.orderService.confirmOrder(generateAddress());

        Assert.assertEquals(1,this.sessionObject.getCart().getPositions().size());

        Assert.assertFalse(orderDAO.isAddOrderFlag());

    }

    @Test
    public void confirmOrderWithTooBigQuantityTest() {

        this.orderDAO.setAddOrderFlag(false);

        this.sessionObject.getCart().getPositions().clear();
        Assert.assertEquals(0,this.sessionObject.getCart().getPositions().size());

        this.sessionObject.getCart().getPositions().add(generateOrderPosition("INNY",100));

        this.orderService.confirmOrder(generateAddress());

        Assert.assertEquals(1,this.sessionObject.getCart().getPositions().size());

        Assert.assertFalse(orderDAO.isAddOrderFlag());

    }

    @Test
    public void confirmOrderTest() {
        this.orderDAO.setAddOrderFlag(false);
        this.motorcycleDAO.setUpdateFlag(false);

        this.sessionObject.getCart().getPositions().clear();
        Assert.assertEquals(0,this.sessionObject.getCart().getPositions().size());

        this.sessionObject.getCart().getPositions().add(generateOrderPosition("INNYCALKIEM",1));

        this.orderService.confirmOrder(generateAddress());

        Assert.assertEquals(0,this.sessionObject.getCart().getPositions().size());

        Assert.assertTrue(orderDAO.isAddOrderFlag());

        Assert.assertTrue(this.motorcycleDAO.isUpdateFlag());

    }
    private OrderPosition generateOrderPosition(String vin, int positionQuantity) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setId(1);
        motorcycle.setBrand("Honda");
        motorcycle.setModel("CBR");
        motorcycle.setYear(2005);
        motorcycle.setCapasity(599);
        motorcycle.setPrice(200);
        motorcycle.setVin(vin);
        motorcycle.setQuantity(20);

        OrderPosition orderPosition = new OrderPosition();
        orderPosition.setMotorcycle(motorcycle);
        orderPosition.setPositionQuantity(positionQuantity);

        return orderPosition;
    }

    private Address generateAddress () {
        Address address = new Address();
        address.setAddress("asdffasd");
        address.setName("asdfasdf");
        address.setSurname("asdfgasdf");
        address.setCity("sdafasdf");
        address.setPhone("123123123");
        address.setPostalCode("12-123");

        return address;
    }















/*        this.orderDAO.setAddOrderFlag(false);
        this.sessionObject.getCart().getPositions().clear();
        Assert.assertEquals(0, this.sessionObject.getCart().getPositions().size());

        this.sessionObject.getCart().getPositions().add(generateOrderPosition("1234-1234-1234-1234", 10));

        this.orderService.confirmOrder(generateAddress());

        Assert.assertEquals(1, this.sessionObject.getCart().getPositions().size());
        Assert.assertFalse(this.orderDAO.isAddOrderFlag());
    }

    @Test
    public void confirmOrderWithTooBigQuantity() {
        this.orderDAO.setAddOrderFlag(false);
        this.sessionObject.getCart().getPositions().clear();
        Assert.assertEquals(0, this.sessionObject.getCart().getPositions().size());

        this.sessionObject.getCart().getPositions().add(generateOrderPosition("1234-1234-5674-1287", 100));

        this.orderService.confirmOrder(generateAddress());

        Assert.assertEquals(1, this.sessionObject.getCart().getPositions().size());
        Assert.assertFalse(this.orderDAO.isAddOrderFlag());
    }

    @Test
    public void confirmOrderTest() {
        this.orderDAO.setAddOrderFlag(false);
        this.bookDAO.setUpdateBookFlag(false);
        this.sessionObject.getCart().getPositions().clear();
        Assert.assertEquals(0, this.sessionObject.getCart().getPositions().size());

        this.sessionObject.getCart().getPositions().add(generateOrderPosition("1234-1234-5674-1287", 1));

        this.orderService.confirmOrder(generateAddress());

        Assert.assertEquals(0, this.sessionObject.getCart().getPositions().size());
        Assert.assertTrue(this.orderDAO.isAddOrderFlag());
        Assert.assertTrue(this.bookDAO.isUpdateBookFlag());
    }

 */




}
