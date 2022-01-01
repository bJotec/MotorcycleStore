package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.OrderPosition;

import java.util.List;

public interface IOrderPositionDAO {
    void addOrderPosition(OrderPosition orderPosition, int orderId);
    List<OrderPosition> getOrderPositionsByOrderId (int orderId);
}
