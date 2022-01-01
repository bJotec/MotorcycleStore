package pl.camp.it.motorcycle.rent.database.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.motorcycle.rent.database.IMotorcycleDAO;
import pl.camp.it.motorcycle.rent.model.Motorcycle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MotorcycleDAOImpl implements IMotorcycleDAO {

    @Autowired
    Connection connection;

    @Override
    public List<Motorcycle> getMotorcycles() {
        List<Motorcycle> motoList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tmotorcycle";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Motorcycle motorcycle = new Motorcycle();
                motorcycle.setId(rs.getInt("id"));
                motorcycle.setBrand(rs.getString("brand"));
                motorcycle.setModel(rs.getString("model"));
                motorcycle.setYear(rs.getInt("year"));
                motorcycle.setCapasity(rs.getInt("capasity"));
                motorcycle.setPrice(rs.getInt("price"));
                motorcycle.setVin(rs.getString("vin"));
                motorcycle.setQuantity(rs.getInt("quantity"));

                motoList.add(motorcycle);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return motoList;
    }

    @Override
    public Optional<Motorcycle> getMotorcycleByVin(String vin) {
        try {
            String sql = "SELECT * FROM tmotorcycle WHERE vin = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1,vin);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                Motorcycle motorcycle = new Motorcycle();

                motorcycle.setId(rs.getInt("id"));
                motorcycle.setBrand(rs.getString("brand"));
                motorcycle.setModel(rs.getString("model"));
                motorcycle.setYear(rs.getInt("year"));
                motorcycle.setCapasity(rs.getInt("capasity"));
                motorcycle.setPrice(rs.getInt("price"));
                motorcycle.setVin(rs.getString("vin"));
                motorcycle.setQuantity(rs.getInt("quantity"));

                return Optional.of(motorcycle);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Motorcycle> getMotorcycleById(int motorcycleId) {
       try {
           String sql = " SELECT * FROM tmotorcycle WHERE id=?";

           PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
           preparedStatement.setInt(1,motorcycleId);

           ResultSet rs = preparedStatement.executeQuery();

           if(rs.next()) {

               Motorcycle motorcycle = new Motorcycle();
               motorcycle.setId(rs.getInt("id"));
               motorcycle.setBrand(rs.getString("brand"));
               motorcycle.setModel(rs.getString("model"));
               motorcycle.setYear(rs.getInt("year"));
               motorcycle.setCapasity(rs.getInt("capasity"));
               motorcycle.setPrice(rs.getInt("price"));
               motorcycle.setVin(rs.getString("vin"));
               motorcycle.setQuantity(rs.getInt("quantity"));

               return Optional.of(motorcycle);
           }

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }

       return Optional.empty();
    }

    @Override
    public void updateMotorcycle(Motorcycle motorcycle) {
        try {
            String sql = "UPDATE tmotorcycle SET brand = ?, model= ?, year= ?, capasity= ?, price= ?, vin= ?, quantity= ? WHERE id = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, motorcycle.getBrand());
            preparedStatement.setString(2, motorcycle.getModel());
            preparedStatement.setInt(3, motorcycle.getYear());
            preparedStatement.setInt(4, motorcycle.getCapasity());
            preparedStatement.setDouble(5, motorcycle.getPrice());
            preparedStatement.setString(6, motorcycle.getVin());
            preparedStatement.setInt(7, motorcycle.getQuantity());

            preparedStatement.setInt(8, motorcycle.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
