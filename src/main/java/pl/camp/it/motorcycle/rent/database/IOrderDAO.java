package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.Order;

import java.util.List;

public interface IOrderDAO {

    void addOrder(Order order);

    List<Order> getOrdersByUsersLogin(String login);

     void returnOrderById(int id);
}

