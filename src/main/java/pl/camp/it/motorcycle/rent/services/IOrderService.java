package pl.camp.it.motorcycle.rent.services;

import pl.camp.it.motorcycle.rent.model.Address;
import pl.camp.it.motorcycle.rent.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    void confirmOrder(Address address);
    List<Order> getOrdersForCurrentUsers();

    void returnOrder(int id);

}
