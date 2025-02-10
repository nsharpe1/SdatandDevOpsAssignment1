package com.keyin;

import java.util.ArrayList;
import java.util.ListIterator;

public class GameStoreCart {
    private ArrayList<Item> item;
    private double totalAmount;
    private double payableAmount;
    private double discount;
    private double tax;
    private String coupon;

    public GameStoreCart() {
        this.item = new ArrayList<Item>();
        this.coupon = "";
        this.totalAmount = 0;
        this.payableAmount = 0;
        this.discount = 0;
        this.tax = 0;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    public int searchCartItem(Item it) {
        int quantity = 0;
        ListIterator<Item> iterator1 = item.listIterator();
        while (iterator1.hasNext()) {
            Item item2 = iterator1.next();
            if (item2.getName().equals(it.getName())) {
                quantity ++;
            }
        }
        return quantity;
    }

    public void addToCart(Item item, int quant) {
        for (int i = 0; i < quant; i++) {
            this.item.add(item);
            item.removeOneQuantity();
        }
    }

    public void showCart() {
        ListIterator<Item> iterator = item.listIterator();
        while (iterator.hasNext()) {
            Item item1 = iterator.next();
            System.out.println(item1);
        }
    }

    public void removeFromCart(Item it, int quant) {
        ListIterator<Item> iterator1 = item.listIterator();
        while (iterator1.hasNext()) {
            Item item2 = iterator1.next();
            if (item2.getName().equals(it.getName())) {
                for (int i = 0; i < quant; i++) {
                    this.item.remove(it);
                    it.addOneQuantity();
                }
                break;
            }
        }
    }

    public double getTotalAmount() {
        ListIterator<Item> iterator2 = item.listIterator();
        this.totalAmount = 0;
        for (Item i: item) {
            totalAmount += i.getPrice();
        }
        return this.totalAmount;
    }

    public void applyCoupon(String coupon) {
        this.coupon = coupon;
        if (coupon.equals("IND10")) {
            this.discount = this.getTotalAmount() * (0.1);
            this.totalAmount = this.totalAmount - this.discount;
        } else {
            this.totalAmount = this.totalAmount;
        }
    }

    public double getPayableAmount() {
        this.payableAmount = 0;
        this.tax = this.totalAmount * (0.15);
        this.payableAmount = this.totalAmount + this.tax;
        return this.payableAmount;
    }

    public void printInvoice() {
        ListIterator<Item> iterator3 = item.listIterator();
        System.out.println();
        System.out.println("Customer Receipt");
        System.out.println();
        System.out.println("Item Name  Price(Before tax)  Price(After tax)");
        while (iterator3.hasNext()) {
            Item item4 = iterator3.next();
            System.out.printf("\n" + item4.getName() + " " + "$" + item4.getPrice() + " " + "$%.2f", item4.getPriceWithTax());
        }
        System.out.println();
        System.out.printf("\n" + "Sub Total : $%.2f", this.getTotalAmount());
        this.applyCoupon(this.coupon);
        System.out.printf("\n" + "Discount  : $%.2f", this.discount);
        this.getPayableAmount();
        System.out.printf("\n" + "Tax       : $%.2f", this.tax);
        System.out.print("\n" +  "Shipping  : Free");
        System.out.printf("\n" + "Total     : $%.2f", this.getPayableAmount());
        System.out.println();
    }
}
