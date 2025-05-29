package tests;

import merch.Drink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkClassTest{
    @Test
    @DisplayName("small size should be 2.0")
    public void testGetPriceSmall(){
        Drink drink1 = new Drink("H3O", "small");
        drink1.getPrice();
        assertEquals(2.0, drink1.getPrice());
    }

    @Test
    @DisplayName("medium size should be 2.5")
    public void testGetPriceMedium(){
        Drink drink1 = new Drink("H3O", "medium");
        drink1.getPrice();
        assertEquals(2.5, drink1.getPrice());
    }

    @Test
    @DisplayName("large size should be 3.0")
    public void testGetPriceLarge(){
        Drink drink1 = new Drink("H3O", "large");
        drink1.getPrice();
        assertEquals(3.0, drink1.getPrice());
    }
}
