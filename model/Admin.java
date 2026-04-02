package com.auction.model;

import java.util.ArrayList;
import java.util.List;
public class Admin extends  User {
    private List<BidTransaction> bidHistory = new ArrayList<>();
    public Admin(String username, String password, String email) {
        super(username, password, email);
    }

    public void manageUser(User user) {
        System.out.println("Quan ly user: " + user.getUsername());
    }
    public void manageAuction(Auction auction) {
        System.out.println("Quan ly phien dau gia: " + auction.getItem().getName());
    }

    public List<BidTransaction> getBidHistory() {
        return bidHistory;
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
        System.out.println("Admin: " + username + ", Email: " + email);
    }
}
