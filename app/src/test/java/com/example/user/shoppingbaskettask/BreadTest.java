package com.example.user.shoppingbaskettask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 21/11/2016.
 */

public class BreadTest {

    Bread bread1;

    @Before
    public void before(){
        bread1 = new Bread("Wonder Bread", "Whole Wheat", 2.50);
    }

    @Test
    public void canGetBrand(){
        assertEquals("Wonder Bread", bread1.getBrand());
    }

    @Test
    public void canGetPrice(){
        assertEquals(2.50, bread1.getPrice());
    }

    @Test
    public void canGetType(){
        assertEquals("Whole Wheat", bread1.getType());
    }

}
