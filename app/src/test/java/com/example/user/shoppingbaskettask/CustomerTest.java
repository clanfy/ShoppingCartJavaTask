package com.example.user.shoppingbaskettask;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;


/**
 * Created by user on 21/11/2016.
 */

public class CustomerTest {

    Customer customer1;
    Customer customer2;
    Milk milk;
    Bread bread;
    Eggs eggs;

    @Before
    public void before(){
        customer1 = new Customer("Doris", 100.00, true);
        customer2 = new Customer("Mavis", 55.50, false);
        milk = new Milk ("Cloverdale");
        bread = new Bread("Wonder Bread", "Whole Wheat", 2.50);
        eggs = new Eggs("Chickening Out", 0.80, 12);
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
    public void canAddBread(){
        customer2.addToBasket(bread);
        assertEquals(1, customer2.basketCount());
    }

    @Test
    public void canGetBreadBrand(){
        assertEquals("Wonder Bread", bread.getBrand());
    }

    @Test
    public void canGetBreadPrice(){
        assertEquals(2.50, bread.getPrice());
    }

    @Test
    public void canAddEggs(){
        customer1.addToBasket(eggs);
        assertEquals(1, customer1.basketCount());
    }

    @Test
    public void canGetEggsBrand(){
        customer1.addToBasket(eggs);
        assertEquals("Chickening Out", eggs.getBrand());
    }

    @Test
    public void canGetEggsPrice(){
        customer2.addToBasket(eggs);
        assertEquals(0.80, eggs.getPrice());
    }

    @Test
    public void canGetEggsAmount(){
        customer1.addToBasket(eggs);
        assertEquals(12, eggs.getAmount());
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

    @Test
    public void canCalculateShoppingTotalOfAllItems(){
        customer1.addToBasket(milk);
        customer1.addToBasket(eggs);
        customer1.addToBasket(bread);
        assertEquals(4.42, customer1.calculateShoppingTotal());
    }

    @Test
    public void canGetMilkBack(){
        customer1.addToBasket(milk);
        Buyable item = customer1.removeItemFromBasket();
        Milk milk = (Milk) item;
        assertEquals("Cloverdale", milk.getBrand());
    }

    @Test
    public void canGetBreadBack(){
        customer1.addToBasket(bread);
        Buyable item = customer1.removeItemFromBasket();
        Bread bread = (Bread) item;
        assertEquals("Wonder Bread", bread.getBrand());
    }

    @Test
    public void canGetEggsBack(){
        customer1.addToBasket(eggs);
        Buyable item = customer1.removeItemFromBasket();
        Eggs eggs = (Eggs) item;
        assertEquals("Chickening Out", eggs.getBrand());
    }

    @Test
    public void canCountOccurrences(){
        customer1.addToBasket(eggs);
        customer1.addToBasket(eggs);
        customer1.addToBasket(eggs);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(milk);
        assertEquals(3, customer1.countItemOccurrences(eggs));
        assertEquals(2, customer1.countItemOccurrences(bread));
        assertEquals(1, customer1.countItemOccurrences(milk));
    }

    @Test
    public void canConfirmBOGOF(){
        customer1.addToBasket(eggs);
        customer1.addToBasket(eggs);
        assertEquals(true, customer1.checkBOGOF(eggs));
    }

    @Test
    public void canConfirmCantBOGOF(){
        customer2.addToBasket(eggs);
        customer2.addToBasket(eggs);
        assertEquals(false, customer2.checkBOGOF(bread));
    }

    @Test
    public void canConfirmMultipleBOGOFS(){
        customer1.addToBasket(milk);
        customer1.addToBasket(milk);
        customer1.addToBasket(milk);
        customer1.addToBasket(milk);
        customer1.addToBasket(bread);
        assertEquals(true, customer1.checkBOGOF(milk));
        assertEquals(false, customer1.checkBOGOF(bread));
        assertEquals(false, customer1.checkBOGOF(eggs));
    }

    @Test
    public void canConfirmThatCantBOGOFIfNotTwoItems(){
        customer1.addToBasket(milk);
        customer1.addToBasket(milk);
        customer1.addToBasket(milk);
        assertEquals(false, customer1.checkBOGOF(milk));
    }

    @Test
    public void canConfirmOver20(){
        customer1.addToBasket(milk);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        assertEquals(21.12, customer1.calculateShoppingTotal());
        assertEquals(true, customer1.checkIfTotalIsGreaterThan20());
        assertEquals(19.01, customer1.subtract10PercentIfOver20());
    }

    @Test
    public void canConfirmIfNotOver20(){
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        assertEquals(5.00, customer1.calculateShoppingTotal());
        assertEquals(5.00, customer1.subtract10PercentIfOver20());
    }

    @Test
    public void canApplyLoyaltyDiscount(){
        customer1.addToBasket(milk);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        customer1.addToBasket(bread);
        assertEquals(21.12, customer1.calculateShoppingTotal());
        assertEquals(19.01, customer1.subtract10PercentIfOver20(), 0.01);
        assertEquals(18.63, customer1.subtractTwoPercentIfHaveLoyaltyCard());
    }

    @Test public void canReturnBOGOFDiscountIfEvenItems(){
        customer2.addToBasket(bread);
        customer2.addToBasket(bread);
        assertEquals(1.25, customer2.returnBOGOFDiscount(bread));
    }


    @Test public void cantReturnBOGOFDiscount(){
        customer2.addToBasket(bread);
        assertEquals(0.00, customer2.returnBOGOFDiscount(bread));
    }

    @Test public void canReturnBOGOFDiscountTotalIfEvenItems(){
        customer2.addToBasket(bread);
        customer2.addToBasket(bread);
        customer2.addToBasket(bread);
        customer2.addToBasket(bread);
        assertEquals(5.00, customer2.bOGOFDiscountsTotal());
    }

    @Test public void canSubtractBOGOFDiscountsFromTotalBasket(){
        customer2.addToBasket(bread);
        customer2.addToBasket(bread);
        customer2.addToBasket(bread);
        customer2.addToBasket(bread);
        customer2.addToBasket(milk);
        assertEquals(6.12, customer2.totalAfterBOGOFDiscount());
    }


//    @Test
//    public void canReturnBOGOFArray(){
//        customer1.addToBasket(milk);
//        customer1.addToBasket(milk);
//        customer1.addToBasket(bread);
//
//        List<String> actual = Arrays.asList("Cloverdale", "Cloverdale", "Wonder Bread");
//        List<String> expected = Arrays.asList(customer1.returnBOGOFStringArray());
//
////        ArrayList<String> expectedOutput = new ArrayList<String>() {"apple", "mango", "grape"};
////        Assert.assertArrayEquals(expectedOutput, customer1.returnBOGOFStringArray());
//
//    }

//    @Test
//    public void confirmBOGOFRemoveItem(){
//        customer1.addToBasket(milk);
//        customer1.addToBasket(milk);
//        customer1.addToBasket(milk);
//        customer1.removeFromBasket(milk);
//        assertEquals(true, customer1.checkBOGOF(milk));
//    }

//    @Test
//    public void canSubtractItemPriceFromTotal(){
//        customer1.addToBasket(milk);
//        customer1.addToBasket(bread);
//        customer1.addToBasket(milk);
//        assertEquals(3.62, customer1.subtractItemPriceFromTotal(milk));
//    }

//    @Test
//    public void canSubtractItemPrice(){
//        assertEquals(-1.12, customer1.subtractItemPrice(milk));
//    }

//    @Test
//    public void canSubtractIfBOGOF(){
//        customer1.addToBasket(milk);
//        customer1.addToBasket(milk);
//        customer1.addToBasket(bread);
//        assertEquals(3.62, customer1.subtractItemPriceIfBOGOF(milk));
//    }

//    @Test
//    public void cantSubtractIfNotBOGOF(){
//        customer1.addToBasket(milk);
//        customer1.addToBasket(eggs);
//        customer1.addToBasket(bread);
//        assertEquals(4.42, customer1.subtractItemPriceIfBOGOF(milk));
//        assertEquals(4.42, customer1.subtractItemPriceIfBOGOF(bread));
//        assertEquals(4.42, customer1.subtractItemPriceIfBOGOF(eggs));
//    }

//    @Test
//    public void canSubtractMultipleBOGOFS(){
//        customer1.addToBasket(milk);
//        customer1.addToBasket(milk);
//        customer1.addToBasket(bread);
//        customer1.addToBasket(bread);
//        assertEquals(3.62, customer1.subtractItemPricesIfMultipleBOGOF());
//
//    }




}
