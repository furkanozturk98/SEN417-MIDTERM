package com.example.midterm;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

    private String name;
    private int price;
    private int rating;
    private int image;
    private int quantity;

    static public ArrayList<CartItem> cart = new ArrayList<>();

    public Product(String name, int price, int rating, int image, int quantity) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.image = image;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
