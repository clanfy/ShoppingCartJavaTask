package com.example.user.shoppingbaskettask;


/**
 * Created by user on 21/11/2016.
 */

public class Bread implements Buyable {

    private String brand;
    private String type;
    private double price;

    public Bread(String brand, String type, double price){
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String newType){
        this.type = newType;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }


}
