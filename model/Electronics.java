package com.auction.model;

public class Electronics extends Item{
    private String brand;
    private String model;

    public Electronics(String name, String description, double startPrice, double currentPrice, Seller seller, String brand, String model) {
        super(name, description, startPrice, currentPrice, seller);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void printInfo() {
        System.out.println(name + " - " + brand + " " + model + ", Gia hien tai: " + currentPrice);
    }


}
