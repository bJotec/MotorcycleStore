package pl.camp.it.motorcycle.rent.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name= "torder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrderPosition> orderPositions = new HashSet<>();
    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;
    @ManyToOne (fetch = FetchType.EAGER)
    private User user;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Order(int id, Set<OrderPosition> orderPositions, Address address, User user, Status status) {
        this.id = id;
        this.orderPositions = orderPositions;
        this.address = address;
        this.user = user;
        this.status = status;
    }

    public Order() {
    }

    public double calculateSum() {
        double sum = 0.0;
        for (OrderPosition orderPosition : this.orderPositions) {
            sum += orderPosition.getPositionQuantity() * orderPosition.getMotorcycle().getPrice();
        }
        return Math.round(sum*100)/100.0;
    }

    public Set<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(Set<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        NEW,
        REALIZATION,
        DELIVERY,
        DONE
    }
}
