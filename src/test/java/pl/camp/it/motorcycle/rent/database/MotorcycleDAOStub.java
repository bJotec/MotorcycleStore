package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.Motorcycle;

import java.util.List;
import java.util.Optional;

public class MotorcycleDAOStub implements IMotorcycleDAO {

    private boolean updateFlag = false ;

    @Override
    public List<Motorcycle> getMotorcycles() {
        return null;
    }

    @Override
    public Optional<Motorcycle> getMotorcycleByVin(String vin) {
        if (vin.equals("VINVINVINVIN")) {
            return Optional.empty();
        } else {
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.setId(1);
            motorcycle.setBrand("Honda");
            motorcycle.setModel("CBR");
            motorcycle.setYear(2005);
            motorcycle.setCapasity(599);
            motorcycle.setPrice(200);
            motorcycle.setVin(vin);
            motorcycle.setQuantity(10);
            return Optional.of(motorcycle);
        }
    }


    @Override
    public Optional<Motorcycle> getMotorcycleById(int motorcycleId) {
        return Optional.empty();
    }

    @Override
    public void updateMotorcycle(Motorcycle motorcycle) {
        this.updateFlag = true ;
    }

    public boolean isUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(boolean updateFlag) {
        this.updateFlag = updateFlag;
    }
}
