package pl.camp.it.motorcycle.rent.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.motorcycle.rent.database.IMotorcycleDAO;
import pl.camp.it.motorcycle.rent.model.Motorcycle;
import pl.camp.it.motorcycle.rent.model.OrderPosition;
import pl.camp.it.motorcycle.rent.services.ICartService;
import pl.camp.it.motorcycle.rent.sesion.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IMotorcycleDAO motorcycleDatabase;

    @Override
    public void addToCart(String vin) {

        Optional<Motorcycle> motorcyclebox = motorcycleDatabase.getMotorcycleByVin(vin);

        if (!motorcyclebox.isPresent()) {
            return;
        }

        for (OrderPosition orderPosition : sessionObject.getCart().getPositions()) {
            if (orderPosition.getMotorcycle().getVin().equals(vin)) {
                orderPosition.increaseQuantity();
                return;
            }
        }
        OrderPosition orderPosition = new OrderPosition();
        orderPosition.setMotorcycle(motorcyclebox.get());
        orderPosition.setPositionQuantity(1);

        this.sessionObject.getCart().getPositions().add(orderPosition);
    }
}
