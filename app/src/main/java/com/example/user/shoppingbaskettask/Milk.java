package com.example.user.shoppingbaskettask;

/**
 * Created by user on 21/11/2016.
 */

public class Milk implements Buyable {

    private String brand;
    private double price;

    public Milk(String brand){
        this.brand = brand;
        this.price = 1.12;
    }

    public String getBrand(){
        return this.brand;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }


}
