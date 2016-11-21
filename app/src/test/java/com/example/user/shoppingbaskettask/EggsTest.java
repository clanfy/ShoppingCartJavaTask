package com.example.user.shoppingbaskettask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 21/11/2016.
 */

public class EggsTest {

    Eggs eggs1;

    @Before
    public void before(){
        eggs1 = new Eggs("Chickening Out", 0.80, 12);
    }

    @Test
    public void canGetBrand(){
        assertEquals("Chickening Out", eggs1.getBrand());
    }

    @Test
    public void canGetPrice(){
        assertEquals(0.80, eggs1.getPrice());
    }

    @Test
    public void canSetPrice(){
        eggs1.setPrice(0.89);
        assertEquals(0.89, eggs1.getPrice());
    }


    @Test
    public void canGetAmount(){
        assertEquals(12, eggs1.getAmount());
    }


}
