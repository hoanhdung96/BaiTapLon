package com.auction.model;

import java.time.LocalDateTime;

public class BidTransaction extends Entity {
    private Auction auction;
    private Bidder bidder;
    private double amount;
    private LocalDateTime timestamp;

    public BidTransaction(Auction auction, Bidder bidder, double amount) {
        super();
        this.auction = auction;
        this.bidder = bidder;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }
    public Bidder getBidder() {
        return bidder;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public void printInfo() {
        System.out.println("Bidder: " + bidder.getUsername() + ", Gia: " + amount + ", thoiGian: " + timestamp);
    }
}
