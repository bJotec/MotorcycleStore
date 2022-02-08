package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.Order;

import java.util.List;
import java.util.Optional;

public class OrderDAOStub implements IOrderDAO{

    private boolean addOrderFlag = false;

    @Override
    public void addOrder(Order order) {

        this.addOrderFlag = true ;
    }

    @Override
    public List<Order> getOrdersByUsersLogin(String login) {
        return null;
    }

    @Override
    public void returnOrderById(Order order) {

    }

    @Override
    public Optional<Order> getOrdersById(int id) {
        return Optional.empty();
    }

    @Override
    public void addOrderWhichRemove(Order order) {

    }

    public boolean isAddOrderFlag() {
        return addOrderFlag;
    }

    public void setAddOrderFlag(boolean addOrderFlag) {
        this.addOrderFlag = addOrderFlag;
    }
}
