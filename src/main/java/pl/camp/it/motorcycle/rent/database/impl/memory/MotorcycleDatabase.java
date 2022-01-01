package pl.camp.it.motorcycle.rent.database.impl.memory;

import org.springframework.stereotype.Repository;
import pl.camp.it.motorcycle.rent.database.IMotorcycleDAO;
import pl.camp.it.motorcycle.rent.model.Motorcycle;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MotorcycleDatabase implements IMotorcycleDAO {
    private final List<Motorcycle> motorcycles = new ArrayList<>();

    public MotorcycleDatabase() {

        this.motorcycles.add(new Motorcycle(1,"Honda","CBR1000",2007,998,250,"PC3533M22235645645",3));
        this.motorcycles.add(new Motorcycle(2,"Suzuki","GSXR1000",2008,999,280,"SC3222O22235645645",2));
        this.motorcycles.add(new Motorcycle(3,"Kawasaki","ZX636",2004,636,200,"KW23233W22223345645",1));
        this.motorcycles.add(new Motorcycle(4,"Honda","CBR600",2001,600,200,"PC3533M111111111",5));
        this.motorcycles.add(new Motorcycle(5,"Yamaha","R6",2014,599,220,"YMR65555433M256564654",8));

    }

    @Override
    public List<Motorcycle> getMotorcycles() {
        return motorcycles;
    }

    @Override
    public Optional<Motorcycle> getMotorcycleByVin(String vin) {
        for (Motorcycle motorcycle : this.motorcycles) {
            if(motorcycle.getVin().equals(vin)) {
                return Optional.of(motorcycle);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Motorcycle> getMotorcycleById(int motorcycleId) {
        throw new NotImplementedException();
    }

    @Override
    public void updateMotorcycle(Motorcycle motorcycle) {
        throw new NotImplementedException();
    }
}
