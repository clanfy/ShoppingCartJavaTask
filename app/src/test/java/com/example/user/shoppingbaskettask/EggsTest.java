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

}
