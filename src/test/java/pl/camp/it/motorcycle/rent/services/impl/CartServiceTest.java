package pl.camp.it.motorcycle.rent.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.it.motorcycle.rent.configuration.AppConfiguration;
import pl.camp.it.motorcycle.rent.services.ICartService;
import pl.camp.it.motorcycle.rent.sesion.SessionObject;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfiguration.class})
public class CartServiceTest {

    @Resource
    SessionObject sessionObject;

    @Autowired
    ICartService cartService;

    @Test
    public void addToCartIncorrectVinTest() {
        String vin = "JH2PC356665554322";

        this.sessionObject.getCart().getPositions().clear();

        Assert.assertEquals(0, this.sessionObject.getCart().getPositions().size());

        this.cartService.addToCart(vin);

        Assert.assertEquals(0, this.sessionObject.getCart().getPositions().size());
    }

    @Test
    public void addMotorcycleToCart() {
        String vin = "PC3533M22235645645";

        this.sessionObject.getCart().getPositions().clear();

        Assert.assertEquals(0, this.sessionObject.getCart().getPositions().size());

        this.cartService.addToCart(vin);

        Assert.assertEquals(1, this.sessionObject.getCart().getPositions().size());

        this.cartService.addToCart(vin);

        Assert.assertEquals(1, this.sessionObject.getCart().getPositions().size());

        int positionQuantity = this.sessionObject.getCart().getPositions().get(0).getPositionQuantity();
        Assert.assertEquals(2, positionQuantity);
    }
}


