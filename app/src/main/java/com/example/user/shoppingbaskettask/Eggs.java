package com.example.user.shoppingbaskettask;

/**
 * Created by user on 21/11/2016.
 */

public class Eggs implements Buyable {

    private String brand;
    private double price;
    private int amount;

    public Eggs(String brand, double price, int amount){
        this.brand = brand;
        this.price = price;
        this.amount = amount;
    }

    public String getBrand(){
        return this.brand;
    }

    public double getPrice(){
        return this.price;
    }

    public int getAmount(){
        return this.amount;
    }

}
