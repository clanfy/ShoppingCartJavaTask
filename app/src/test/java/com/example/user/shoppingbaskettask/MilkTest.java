package com.example.user.shoppingbaskettask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 21/11/2016.
 */

public class MilkTest {

    Milk milk1;

    @Before
    public void before(){
        milk1 = new Milk ("Cloverdale");
    }

    @Test
    public void canGetBrand(){
        assertEquals("Cloverdale", milk1.getBrand());
    }

    @Test
    public void canGetPrice(){
        assertEquals(1.12, milk1.getPrice());
    }

    @Test
    public void canSetPrice(){
        milk1.setPrice(0.99);
        assertEquals(0.99, milk1.getPrice());
    }
}
