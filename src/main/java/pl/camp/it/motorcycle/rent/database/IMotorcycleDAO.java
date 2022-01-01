package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.Motorcycle;

import java.util.List;
import java.util.Optional;

public interface IMotorcycleDAO {

    List<Motorcycle> getMotorcycles();
    Optional<Motorcycle> getMotorcycleByVin(String vin);
    Optional<Motorcycle> getMotorcycleById(int motorcycleId);
    void updateMotorcycle(Motorcycle motorcycle);
}
