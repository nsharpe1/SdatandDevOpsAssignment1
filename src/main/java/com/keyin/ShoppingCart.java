package com.keyin;

import java.util.ArrayList;
import java.util.ListIterator;

public class ShoppingCart {
    private ArrayList<Item> item;
    private double totalAmount;
    private double payableAmount;
    private double discount;
    private double tax;
    private String coupon;

    public ShoppingCart () {
        this.item = new ArrayList<Item>();
        this.coupon = "";
        this.totalAmount = 0;
        this.payableAmount = 0;
        this.discount = 0;
        this.tax = 0;
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

    public void removeFromCart(Item i) {
        ListIterator<Item> iterator1 = item.listIterator();
        while (iterator1.hasNext()) {
            Item item2 = iterator1.next();
            if (item2.getName().equals(i.getName())) {
                this.item.remove(i);
                i.addOneQuantity();
                break;
            }
        }
    }

    public double getTotalAmount() {
        ListIterator<Item> iterator2 = item.listIterator();
        this.totalAmount = 0;
        while(iterator2.hasNext()) {
            Item item3 = iterator2.next();
            this.totalAmount = this.totalAmount + (item3.getPrice() * item3.getQuantity());
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
        while (iterator3.hasNext()) {
            Item item4 = iterator3.next();
            System.out.print(item4.getName() + "\t");
            System.out.println(item4.getPrice() + "\t");
            // System.out.println(item4.getPrice() * item4.getQuantity());
        }
        System.out.println("\t\t\t" + "Total   : " + this.getTotalAmount());
        this.applyCoupon(this.coupon);
        System.out.println("\t\t\t" + "Discount : " + this.discount);
        this.getPayableAmount();
        System.out.println("\t\t\t" + "Tax       : " + this.tax);
        System.out.println("\t\t\t" + "Total     : " + this.getPayableAmount());
    }
}
