package com.example.user.shoppingbaskettask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by user on 21/11/2016.
 */

public class CustomerTest {

    Customer customer1;

    @Before
    public void before(){
        customer1 = new Customer("Doris", true);
    }

    @Test
    public void hasName(){
        assertEquals("Doris", customer1.getName());
    }

}
