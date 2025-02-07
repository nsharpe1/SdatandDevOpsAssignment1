package com.keyin;

public class Item {
    private String name;
    private int quantity;
    private double price;

    public Item() {

    }

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void removeOneQuantity() {
        quantity = this.quantity - 1;
    }

    public void addOneQuantity() {
        quantity = this.quantity + 1;
    }

    public String toString() {
        String s = this.name + ",";
        s = s + this.quantity + "\n";
        return s;
    }
}
