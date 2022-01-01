package pl.camp.it.motorcycle.rent.model;

public class Motorcycle {
    private int id;
    private String brand;
    private String model;
    private int year;
    private int capasity;
    private double price;
    private String vin;
    private int quantity;

    public Motorcycle(int id, String brand, String model, int year, int capasity, double price, String vin, int quantity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.capasity = capasity;
        this.price = price;
        this.vin = vin;
        this.quantity = quantity;
    }

    public Motorcycle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public double getPrice() { return price;}

    public void setPrice(double price) {
        this.price = price;
    }
}
