package com.auction.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auction extends Entity {
    private Item item;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isOpen;
    private BidTransaction highesBid;
    private List<BidTransaction> bidHistory;

    public Auction(Item item, LocalDateTime startTime, LocalDateTime endTime) {
        super();
        this.item = item;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isOpen = true;
        this.bidHistory = new ArrayList<>();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public BidTransaction getHighesBid() {
        return highesBid;
    }

    public void setHighesBid(BidTransaction highesBid) {
        this.highesBid = highesBid;
    }

    public List<BidTransaction> getBidHistory() {
        return bidHistory;
    }

    public void setBidHistory(List<BidTransaction> bidHistory) {
        this.bidHistory = bidHistory;
    }

    public  synchronized boolean placeBid(Bidder bidder, double amount) {
        if (!isOpen) {
            System.out.println("Phien dau gia da dong!");
            return false;
        }
        double minPrice = highesBid != null ? highesBid.getAmount() : item.startPrice;
        if (amount <= minPrice) {
            System.out.println("Gia dat thap hon gia hien tai!");
            return false;
        }

        BidTransaction bid = new BidTransaction(this, bidder, amount);
        bidHistory.add(bid);
        highesBid = bid;
        item.currentPrice = amount;
        return true;
    }

    public void closeAuction() {
        isOpen = false;
        System.out.println("Phien dau gia ket thuc. Nguoi thang: " + (highesBid != null ? highesBid.getBidder().getUsername() : "Chua co nguoi thang"));
    }

    @Override
    public void printInfo() {
        System.out.println("Auction san pham: " + item.getName() + ", Gia cao nhat: " + (highesBid != null ? highesBid.getAmount() : item.startPrice));
    }
}
