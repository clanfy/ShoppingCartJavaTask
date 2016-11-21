package com.example.user.shoppingbaskettask;

import java.util.ArrayList;

/**
 * Created by user on 21/11/2016.
 */

public class Customer {

    private String name;
    private ArrayList<Buyable> shoppingBasket;
    private boolean hasLoyaltyCard;

    public Customer(String name, boolean hasLoyaltyCard){
        this.name = name;
        this.shoppingBasket = new ArrayList<Buyable>();
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public String getName(){
        return this.name;
    }

}
