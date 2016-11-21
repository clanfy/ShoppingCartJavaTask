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

    @Before
    public void before(){
        customer1 = new Customer("Doris", 100.00, true);
        customer2 = new Customer("Mavis", 55.50, false);
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

}
