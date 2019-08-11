package by.ander.web.beans;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int id;
    @Expose
    private String name;
    @Expose
    private int bedroom;
    @Expose
    private double square;
    @Expose
    private BigDecimal price;
    @Expose
    private int phone;
    @Expose
    private String picture;

    public Apartment(int id, String name, int bedroom, double square, BigDecimal price, int phone, String picture) {
        this.id = id;
        this.name = name;
        this.bedroom = bedroom;
        this.square = square;
        this.price = price;
        this.phone = phone;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBedroom() {
        return bedroom;
    }

    public double getSquare() {
        return square;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getPhone() {
        return phone;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", name='" + name +
                ", bedroom=" + bedroom +
                ", square=" + square +
                ", price=" + price +
                ", phone=" + phone +
                ", picture='" + picture +
                '}';
    }

    public List<String> getApartmentList(){
        List<String> apartments = new ArrayList<>();
        apartments.add(String.valueOf(getId()));
        apartments.add(getName());
        apartments.add(String.valueOf(getBedroom()));
        apartments.add(String.valueOf(getSquare()));
        apartments.add(String.valueOf(getPrice()));
        apartments.add(String.valueOf(getPhone()));
        apartments.add(getPicture());
        return apartments;
    }
}
