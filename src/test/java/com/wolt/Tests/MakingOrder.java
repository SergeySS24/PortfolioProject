package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base3;
import com.wolt.TestsSupport.MakingOrderSupport;
import com.wolt.TestsSupport.RestaurantCheckSupport;
import org.junit.jupiter.api.Test;


public class MakingOrder extends Base3 {

    MakingOrderSupport step = new MakingOrderSupport();
    RestaurantCheckSupport pace = new RestaurantCheckSupport();


    @Test
    void selectChickenBurger() {
        pace.openCategory("CHICKEN BURGERS")
                .openItemCard("Salted Caramel Chicken", "€11.00");
        step.addExtraItem("bacon ")
                .addExtraItem("pickles")
                .addExtraItem("jalapeno")
                .addExtraItem("cheddar cheese ")
                .addExtraItem("gouda cheese")
                .addExtraItem("halloumi")
                .addExtraItemCounter("Choose up to 1 additional items")
                .submitButtonTotalPrice("€14.00")
                .submitButtonClick()
                .selectedItemOrderQuantity("1")
                .totalOrderPrice("€14.00");
        pace.openCategory("FRIES")
                .openItemCard("Classic French Fries", "€3.00");
        step.itemQuantityIncrease()
                .itemQuantity("2")
                .submitButtonTotalPrice("€6.00")
                .submitButtonClick()
                .totalOrderPrice("€20.00");
        pace.openCategory("DRINKS")
                .openItemCard("Coca Cola", "€1.50");
        step.submitButtonTotalPrice("€1.50")
                .submitButtonClick()
                .totalNumberOfOrderedItems("4")
                .totalOrderPrice("€21.50");
    }
}
