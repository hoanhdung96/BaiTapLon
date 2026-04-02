package com.auction.model;
import java.util.ArrayList;
import java.util.List;

public class Bidder extends  User {
    private List<BidTransaction> myBids;

    public Bidder(String username, String password, String email) {
        super(username, password, email);
        this.myBids = new ArrayList<>();
    }

    public  boolean placeBid(Auction auction, double amount) {
        boolean success = auction.placeBid(this, amount);
        if (success) {
            System.out.println("Bid thanh cong: " + amount);
        } else {
            System.out.println("Bid that bai: " + amount);
        }
        return success;
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
        System.out.println("Bidder: " + username + ", Email: " + email);
    }
}
