package com.example.user.shoppingbaskettask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by user on 21/11/2016.
 */

public class CustomerTest {

    Customer customer1;
    Customer customer2;
    Milk milk;
    Bread bread;

    @Before
    public void before(){
        customer1 = new Customer("Doris", 100.00, true);
        customer2 = new Customer("Mavis", 55.50, false);
        milk = new Milk ("Cloverdale");
        bread = new Bread("Wonder Bread", "Whole Wheat", 2.50);
    }

    @Test
    public void hasName(){
        assertEquals("Doris", customer1.getName());
    }

    @Test
    public void hasLoyaltyCard(){
        assertEquals(true, customer1.getLoyaltyCard());
        assertEquals(false, customer2.getLoyaltyCard());
    }

    @Test
    public void canSetLoyaltyCard(){
        customer1.setLoyaltyCard(false);
        customer2.setLoyaltyCard(true);
        assertEquals(false, customer1.getLoyaltyCard());
        assertEquals(true, customer2.getLoyaltyCard());
    }

    @Test
    public void canGetMoney(){
        double customerMoney = customer1.getMoney();
        assertEquals(100.00, customerMoney);
        assertEquals(55.50, customer2.getMoney());
    }

    @Test
    public void basketStartsEmpty(){
        assertEquals(0,customer1.basketCount());
    }

    @Test
    public void canAddMilk(){
        customer1.addToBasket(milk);
        assertEquals(1, customer1.basketCount());
    }

    @Test
    public void canGetMilkBrand(){
        assertEquals("Cloverdale", milk.getBrand());
    }

    @Test
    public void canGetMilkPrice(){
        assertEquals(1.12, milk.getPrice());
    }

    @Test
    public void canAddMilkAndBread(){
        customer2.addToBasket(milk);
        customer2.addToBasket(bread);
        assertEquals(2, customer2.basketCount());
    }

    @Test
    public void canRemoveItem(){
        customer1.addToBasket(milk);
        customer1.addToBasket(milk);
        customer1.addToBasket(bread);
        customer1.removeFromBasket(milk);
        assertEquals(2, customer1.basketCount());
    }

    @Test
    public void wontRemoveItemIfNotPresent(){
        customer1.addToBasket(milk);
        customer1.addToBasket(milk);
        customer1.removeFromBasket(bread);
        assertEquals(2, customer1.basketCount());
    }

    @Test
    public void canEmptyBasket(){
        customer2.addToBasket(milk);
        customer2.addToBasket(bread);
        customer2.emptyBasket();
        assertEquals(0, customer2.basketCount());
    }

    @Test
    public void canCalculateShoppingTotal(){
        customer2.addToBasket(milk);
        customer2.addToBasket(bread);
        assertEquals(3.62, customer2.calculateShoppingTotal());
    }



}
