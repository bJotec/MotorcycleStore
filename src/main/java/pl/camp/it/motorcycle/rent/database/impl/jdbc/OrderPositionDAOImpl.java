package pl.camp.it.motorcycle.rent.database.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.motorcycle.rent.database.IMotorcycleDAO;
import pl.camp.it.motorcycle.rent.database.IOrderPositionDAO;
import pl.camp.it.motorcycle.rent.model.Motorcycle;
import pl.camp.it.motorcycle.rent.model.OrderPosition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderPositionDAOImpl implements IOrderPositionDAO {

    @Autowired
    Connection connection;

    @Autowired
    IMotorcycleDAO motorcycleDAO;

    @Override
    public void addOrderPosition(OrderPosition orderPosition, int orderId) {

        try {
            String sql = "INSERT INTO torderposition (id, order_id, motorcycle_id, positionquantity) VALUES (NULL, ?, ?, ?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,orderId);
            preparedStatement.setInt(2,orderPosition.getMotorcycle().getId());
            preparedStatement.setInt(3,orderPosition.getPositionQuantity());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            orderPosition.setId(rs.getInt(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<OrderPosition> getOrderPositionsByOrderId(int orderId) {
        List<OrderPosition> listOrderPositions = new ArrayList<>();

        try {
            String sql = "SELECT * FROM torderposition WHERE order_id = ? ";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                OrderPosition orderPosition = new OrderPosition();

                orderPosition.setId(rs.getInt("id"));
                orderPosition.setPositionQuantity(rs.getInt("positionquantity"));

                int motorcycleId = rs.getInt("motorcycle_id");
                Optional<Motorcycle> motorcycleBox = this.motorcycleDAO.getMotorcycleById(motorcycleId);

                if (motorcycleBox.isPresent()) {
                    orderPosition.setMotorcycle(motorcycleBox.get());
                }

                listOrderPositions.add(orderPosition);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listOrderPositions;
    }

    @Override
    public void returnOrderPositionByUserId() {


        try {

            String sql =  "DELETE FROM torderposition WHERE NOT EXISTS ( SELECT NULL FROM torder f WHERE f.id = order_id )";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.executeUpdate();


    } catch (SQLException throwables) {
    throwables.printStackTrace();
}

    }

}

