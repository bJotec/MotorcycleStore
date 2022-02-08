package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderDAO {

    void addOrder(Order order);

    List<Order> getOrdersByUsersLogin(String login);

     void returnOrderById(Order order);

    Optional<Order> getOrdersById(int id);

    void addOrderWhichRemove(Order order);
}

