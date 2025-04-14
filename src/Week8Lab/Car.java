package Week8Lab;

import java.io.Serializable;

public class Car implements Comparable<Car>, Serializable {

    private static final long serialVersionUID = 1L;


    private int id;
    private int year;
    private String make;
    private String model;
    private String color;
    private int price;

    public Car(int id, int year, String make, String model, String color, int price) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price;
    }

    @Override
    public int compareTo(Car o) {
        return this.getModel().compareTo(o.getModel());
//        return this.getModel().compareToIgnoreCase(o.getModel());

    }
}
