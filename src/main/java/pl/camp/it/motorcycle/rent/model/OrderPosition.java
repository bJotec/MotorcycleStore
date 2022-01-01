package pl.camp.it.motorcycle.rent.model;

public class OrderPosition {

    private int id;
    private Motorcycle motorcycle;
    private int positionQuantity;

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public int getPositionQuantity() {
        return positionQuantity;
    }

    public void setPositionQuantity(int positionQuantity) {
        this.positionQuantity = positionQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void increaseQuantity() {
        this.positionQuantity++;
    }
}
