package com.example.user.shoppingbaskettask;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.round;

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

    public int countItemOccurrences(Buyable item){
        int occurrences = Collections.frequency(this.shoppingBasket, item);
        return occurrences;
    }

    public boolean checkBOGOF(Buyable item){

        if (countItemOccurrences(item) >= 2 && (countItemOccurrences(item) % 2 == 0)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkIfTotalIsGreaterThan20(){

        if (calculateShoppingTotal() >= 20.00) {
            return true;
        } else {
            return false;
        }
    }

    public double subtract10PercentIfOver20(){

        if (checkIfTotalIsGreaterThan20()) {

            double calculation = calculateShoppingTotal() * 0.10;
            double roundOff = Math.round(calculation * 100.0) / 100.0;

           return calculateShoppingTotal() - roundOff;
        } else {
            return calculateShoppingTotal();
        }
    }


//    public ArrayList<String> returnBOGOFStringArray(){
//
//        ArrayList<String> stringBasket = new ArrayList<String>();
//
//        for (Buyable item : this.shoppingBasket){
//
//            stringBasket.add(item.getBrand());
//        }
//
//        return stringBasket;
//    }


//    public double subtractItemPriceFromTotal(Buyable item){
//        double customerTotal = calculateShoppingTotal();
//        return customerTotal - item.getPrice();
//
//    }

//    public double subtractItemPrice(Buyable item){
//        return -(item.getPrice());
//    }

//    public double subtractItemPriceIfBOGOF(Buyable item) {
//
//        boolean canBOGOF = checkBOGOF(item);
//
//        if (canBOGOF) {
//            return calculateShoppingTotal() + subtractItemPrice(item);
//        }
//        else {
//            return calculateShoppingTotal();
//        }
//    }


    // working on going through shopping basket array and subtracting item prices of multiple BOGOFS
//
//    public double subtractItemPricesIfMultipleBOGOF() {
//
//        double total = 0;
//
//        for (Buyable item : this.shoppingBasket){
//
//           total += subtractItemPriceIfBOGOF(item);
//
//        }
//        return total;
//
//    }




}
