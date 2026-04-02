package com.auction.model;

import java.util.ArrayList;
import java.util.List;

public class Seller extends  User {
    private List<Item> itemsForSale;

    public Seller(String username, String password, String email) {
        super(username, password, email);
        itemsForSale = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemsForSale.add(item);
        System.out.println("Da them san pham: " + item.getName());
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void logout() {
        System.out.println(username + " da dang xuat.");
    }

    @Override
    public void printInfo() {
        System.out.println("Seller: " + username + ", Email: " + email);
    }
}
