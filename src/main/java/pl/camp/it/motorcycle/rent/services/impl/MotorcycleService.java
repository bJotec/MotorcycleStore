package pl.camp.it.motorcycle.rent.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.motorcycle.rent.database.IMotorcycleDAO;
import pl.camp.it.motorcycle.rent.model.Motorcycle;
import pl.camp.it.motorcycle.rent.services.IMotorcycleService;

import java.util.List;

@Service
public class MotorcycleService implements IMotorcycleService {

        @Autowired
        IMotorcycleDAO motorcycleDatabase;

        @Override
        public List<Motorcycle> getAllMotorcycles() {
                return this.motorcycleDatabase.getMotorcycles();
        }

}
