package pl.camp.it.motorcycle.rent.database.impl.memory;

import org.springframework.stereotype.Repository;
import pl.camp.it.motorcycle.rent.database.IOrderDAO;
import pl.camp.it.motorcycle.rent.model.Order;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDatabase implements IOrderDAO {
   private final  List<Order> orders = new ArrayList<>();


    @Override
    public void addOrder(Order order){
        this.orders.add(order);
    }

    @Override
    public List<Order> getOrdersByUsersLogin(String login) {
            List<Order> result = new ArrayList<>();
            for( Order order : this.orders) {
                if(order.getUser().getLogin().equals(login)) {
                    result.add(order);
                }
            }

            return result;
    }

    @Override
    public void returnOrderById(Order id) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<Order> getOrdersById(Order order) {
        throw new NotImplementedException();
    }
}
