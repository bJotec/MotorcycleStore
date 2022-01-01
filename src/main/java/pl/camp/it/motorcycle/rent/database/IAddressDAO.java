package pl.camp.it.motorcycle.rent.database;

import pl.camp.it.motorcycle.rent.model.Address;

import java.util.Optional;

public interface IAddressDAO {

    void addAddress(Address address);
    Optional<Address> getAddressById( int id );

}
