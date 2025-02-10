package com.keyin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.text.DecimalFormat;

public class GameStoreCartTest {

    @Test
    public void testCartAddRemove() {
        Item i1 = new Item("Call of Duty Modern Warfare", 2, 39.99);
        Item i2 = new Item("Grand Theft Auto V", 5, 29.99);
        Item i3 = new Item("Red Dead Redemption", 8, 24.99);

        Inventory inventory = new Inventory();
        inventory.addToInventory(i1);
        inventory.addToInventory(i2);
        inventory.addToInventory(i3);
        inventory.inventoryList();

        GameStoreCart cart = new GameStoreCart();
        cart.addToCart(i1, 1);
        cart.addToCart(i2, 3);
        cart.addToCart(i3, 6);
        Assertions.assertEquals(3, cart.searchCartItem(i2));
        Assertions.assertNotEquals(2, cart.searchCartItem(i2));

        cart.removeFromCart(i3, 3);
        Assertions.assertEquals(3, cart.searchCartItem(i3));
        Assertions.assertNotEquals(1, cart.searchCartItem(i2));

        cart.getTotalAmount();
        double payableAmount = cart.getPayableAmount();
        cart.applyCoupon("IND10");

        cart.printInvoice();
    }

    @Test
    public void testCartTotal() {
        Item i1 = new Item("Call of Duty Modern Warfare", 2, 39.99);
        Item i2 = new Item("Grand Theft Auto V", 5, 29.99);
        Item i3 = new Item("Red Dead Redemption", 8, 24.99);

        Inventory inventory = new Inventory();
        inventory.addToInventory(i1);
        inventory.addToInventory(i2);
        inventory.addToInventory(i3);
        inventory.inventoryList();

        GameStoreCart cart = new GameStoreCart();
        cart.addToCart(i1, 1);
        cart.addToCart(i2, 3);
        cart.addToCart(i3, 6);
        cart.removeFromCart(i3, 3);

        cart.getTotalAmount();
        double payableAmount = cart.getPayableAmount();
        cart.applyCoupon("IND10");
        DecimalFormat df = new DecimalFormat("0.00");
        double formattedAmount = Double.parseDouble(df.format(cart.getPayableAmount()));
        Assertions.assertEquals(212.10, formattedAmount);
        Assertions.assertNotEquals(134.96, formattedAmount);

        cart.printInvoice();
    }
}