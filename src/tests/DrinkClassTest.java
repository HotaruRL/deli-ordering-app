package tests;

import merch.Drink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkClassTest{
    @Test
    @DisplayName("small size should be 2.0")
    public void testCalculateUnitPriceSmall(){
        Drink drink1 = new Drink("H3O", "small");
        drink1.calculateUnitPrice();
        assertEquals(2.0, drink1.calculateUnitPrice());
    }

    @Test
    @DisplayName("medium size should be 2.5")
    public void testCalculateUnitPriceMedium(){
        Drink drink1 = new Drink("H3O", "medium");
        drink1.calculateUnitPrice();
        assertEquals(2.5, drink1.calculateUnitPrice());
    }

    @Test
    @DisplayName("large size should be 3.0")
    public void testCalculateUnitPriceLarge(){
        Drink drink1 = new Drink("H3O", "large");
        drink1.calculateUnitPrice();
        assertEquals(3.0, drink1.calculateUnitPrice());
    }
}
