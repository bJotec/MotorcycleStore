package pl.camp.it.motorcycle.rent.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.motorcycle.rent.database.IMotorcycleDAO;
import pl.camp.it.motorcycle.rent.database.IOrderDAO;
import pl.camp.it.motorcycle.rent.model.*;
import pl.camp.it.motorcycle.rent.services.IOrderService;
import pl.camp.it.motorcycle.rent.sesion.SessionObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IMotorcycleDAO motorcycleDatabase;

    @Autowired
    IOrderDAO orderDatabase;

    @Resource
    SessionObject sessionObject;

    @Override
    public void confirmOrder(Address address) {
        Cart cart = this.sessionObject.getCart();
        List<OrderPosition> orderPositions = cart.getPositions();

        for (OrderPosition orderPosition : orderPositions) {
            String vin = orderPosition.getMotorcycle().getVin();
            Optional<Motorcycle> motorcyclebox = this.motorcycleDatabase.getMotorcycleByVin(vin);
            if(!motorcyclebox.isPresent()) {
                return ;
            }
            if (orderPosition.getPositionQuantity() > motorcyclebox.get().getQuantity()) {
                return;
            }
        }

        Order order = new Order();
        /*order.setId(new Random().nextInt(1000000));*/

        order.setOrderPositions(new HashSet<>(orderPositions)); // zmiana listy na zbiór
        order.setAddress(address);
        order.setUser(this.sessionObject.getUser());
        order.setStatus(Order.Status.NEW);
        this.orderDatabase.addOrder(order);

        for (OrderPosition orderPosition : orderPositions) {
            String vin = orderPosition.getMotorcycle().getVin();
            Optional<Motorcycle> motorcyclebox = this.motorcycleDatabase.getMotorcycleByVin(orderPosition.getMotorcycle().getVin());
            Motorcycle motorcycle = motorcyclebox.get();
            motorcycle.setQuantity(motorcycle.getQuantity()-orderPosition.getPositionQuantity());
            this.motorcycleDatabase.updateMotorcycle(motorcycle);
        }

        cart.setPositions(new ArrayList<>());
    }

    @Override
    public List<Order> getOrdersForCurrentUsers() {
        return this.orderDatabase.getOrdersByUsersLogin(this.sessionObject.getUser().getLogin());
    }

    @Override
    public void returnOrder() {


        this.orderDatabase.returnOrderById(this.sessionObject.getOrder());
    }

    @Override
    public Optional<Order> getOrdersById() {

        return this.orderDatabase.getOrdersById(this.sessionObject.getOrder().getId());

    }
   /* @Override
    public void returnOrderPositionByUserId() {

        this.orderPositionDAO.returnOrderPositionByUserId();
    }*/

}
