package com.keyin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ShoppingTest {

    @Test
    public void testShopping() {
        Item i1 = new Item("Call of Duty Modern Warfare", 2, 39.99);
        Item i2 = new Item("Grand Theft Auto V", 5, 29.99);
        Item i3 = new Item("Red Dead Redemption", 8, 24.99);

        Inventory inventory = new Inventory();
        inventory.addToInventory(i1);
        inventory.addToInventory(i2);
        inventory.addToInventory(i3);
        inventory.inventoryList();

        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(i1, 1);
        cart.addToCart(i2, 3);
        cart.addToCart(i3, 6);
        cart.removeFromCart(i2);
        double payableAmount = cart.getPayableAmount();
        cart.printInvoice();
        inventory.inventoryList();
    }

}
