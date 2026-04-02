package com.auction;

import com.auction.model.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // 1. Tạo Seller
        Seller seller = new Seller("seller1", "123", "seller@gmail.com");

        // 2. Tạo Item
        Electronics laptop = new Electronics(
                "Laptop Dell",
                "Laptop gaming",
                1000,
                1000,   // currentPrice = startPrice
                seller,
                "Dell",
                "G15"
        );

        // 3. Seller thêm sản phẩm
        seller.addItem(laptop);

        // 4. Tạo Auction
        Auction auction = new Auction(
                laptop,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10)
        );

        // 5. Tạo 2 Bidder
        Bidder bidder1 = new Bidder("user1", "123", "u1@gmail.com");
        Bidder bidder2 = new Bidder("user2", "123", "u2@gmail.com");
        Bidder bidder3 = new Bidder("user3", "156", "u3@gamil.com");

        // 6. Test login
        System.out.println("Login bidder1: " + bidder1.login("user1", "123"));

        System.out.println("\n=== BAT DAU DAU GIA ===");

        // 7. Đặt giá
        bidder1.placeBid(auction, 1100); // OK
        bidder2.placeBid(auction, 1100); // FAIL
        bidder2.placeBid(auction, 1200); // OK
        bidder1.placeBid(auction, 1300); // OK
        bidder3.placeBid(auction, 5000);
        bidder1.placeBid(auction, 6000);
        // 8. In thông tin auction
        System.out.println("\n=== THONG TIN PHIEN ===");
        auction.printInfo();

        // 9. Đóng phiên đấu giá
        System.out.println("\n=== KET THUC PHIEN ===");
        auction.closeAuction();

        // 10. Thử bid sau khi đóng
        bidder2.placeBid(auction, 1500);

        // 11. In lịch sử bid
        System.out.println("\n=== LICH SU DAU GIA ===");
        for (BidTransaction bid : auction.getBidHistory()) {
            bid.printInfo();
        }
    }
}