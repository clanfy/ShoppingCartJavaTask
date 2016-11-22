package com.example.user.shoppingbaskettask;

import java.util.ArrayList;

/**
 * Created by user on 21/11/2016.
 */

public class Customer {

    private String name;
    private ArrayList<Buyable> shoppingBasket;
    private double money;
    private boolean hasLoyaltyCard;

    public Customer(String name, double money, boolean hasLoyaltyCard){
        this.name = name;
        this.shoppingBasket = new ArrayList<Buyable>();
        this.money = money;
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public String getName(){
        return this.name;
    }

    public boolean getLoyaltyCard(){
        return this.hasLoyaltyCard;
    }

    public double getMoney(){
        return this.money;
    }

    public void setLoyaltyCard(boolean setCard){
        this.hasLoyaltyCard = setCard;
    }

    public int basketCount(){
        return this.shoppingBasket.size();
    }

    public void addToBasket(Buyable item){
        this.shoppingBasket.add(item);
    }

    public void removeFromBasket(Buyable item){
        this.shoppingBasket.remove(item);
    }

    public Buyable removeItemFromBasket() {
        if (basketCount() > 0) {
            return shoppingBasket.remove(0);
        }
        return null;
    }

    public void emptyBasket(){
        this.shoppingBasket.clear();
    }

    public double calculateShoppingTotal(){

        double total = 0;

        for (Buyable item : this.shoppingBasket){
            total += item.getPrice();
        }
        return total;
    }




}
