package tests;

import merch.Drink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkClassTest{
    @Test
    @DisplayName("small size should be 2.0")
    public void testCalculatePriceSmall(){
        Drink drink1 = new Drink("H3O", "small");
        drink1.calculatePrice();
        assertEquals(2.0, drink1.calculatePrice());
    }

    @Test
    @DisplayName("medium size should be 2.5")
    public void testCalculatePriceMedium(){
        Drink drink1 = new Drink("H3O", "medium");
        drink1.calculatePrice();
        assertEquals(2.5, drink1.calculatePrice());
    }

    @Test
    @DisplayName("large size should be 3.0")
    public void testCalculatePriceLarge(){
        Drink drink1 = new Drink("H3O", "large");
        drink1.calculatePrice();
        assertEquals(3.0, drink1.calculatePrice());
    }
}
