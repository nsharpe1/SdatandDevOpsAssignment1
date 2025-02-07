package com.keyin;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> item;

    public Inventory() {
        this.item = new ArrayList<Item>();
    }

    public Inventory(ArrayList<Item> item) {
        this.item = item;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    public void addToInventory(Item item) {
        this.item.add(item);
    }

    public void inventoryList() {
        for (Item i: item) {
            System.out.println(i.getName() + " " + "Quantity Stock:" + i.getQuantity() + " " + "$" + i.getPrice());
        }
    }
}
