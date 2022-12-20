package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base3;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class MakingOrder extends Base3 {


    @Test
    void selectChickenBurger() {
        $$(".Categories-module__categoryLink___WM_5v").find(Condition.text("CHICKEN BURGERS")).shouldHave(Condition.text("CHICKEN BURGERS")).click();
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text("Salted Caramel Chicken"))
                .shouldHave(Condition.text("Salted Caramel Chicken")).click();
        $$(".Checkboxes__CheckboxWrapper-sc-1skk1h0-0").find(Condition.text("bacon "))
                .shouldHave(Condition.text("bacon ")).click();
        $$(".Checkboxes__CheckboxWrapper-sc-1skk1h0-0").find(Condition.text("pickles"))
                .shouldHave(Condition.text("pickles")).click();
        $$(".Checkboxes__CheckboxWrapper-sc-1skk1h0-0").find(Condition.text("jalapeno"))
                .shouldHave(Condition.text("jalapeno")).click();
        $$(".Checkboxes__CheckboxWrapper-sc-1skk1h0-0").find(Condition.text("cheddar cheese "))
                .shouldHave(Condition.text("cheddar cheese ")).click();
        $$(".Checkboxes__CheckboxWrapper-sc-1skk1h0-0").find(Condition.text("gouda cheese"))
                .shouldHave(Condition.text("gouda cheese")).click();
        $$(".Checkboxes__CheckboxWrapper-sc-1skk1h0-0").find(Condition.text("halloumi"))
                .shouldHave(Condition.text("halloumi")).click();
        $(".Options__OptionDescription-sc-1yd6u15-7").shouldHave(Condition.text("Choose up to 1 additional items"));
        $(".ProductViewFooter__SubmitButtonContent-sc-34t03j-5").shouldHave(Condition.text("Add to order"))
                .shouldHave(Condition.text("€14.00"));
        $(".ProductViewFooter__SubmitButtonContent-sc-34t03j-5").shouldHave(Condition.text("Add to order"))
                .shouldHave(Condition.text("€14.00")).click();

        $(".PlusCount__Label-sc-1mt4kjx-1").shouldHave(Condition.text("1"));
        $(".CartViewButton__Price-sc-8iz5bz-2").shouldHave(Condition.text("€14.00"));

        $$(".Categories-module__categoryLink___WM_5v").find(Condition.text("FRIES")).shouldHave(Condition.text("FRIES")).click();
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text("Classic French Fries"))
                .shouldHave(Condition.text("Classic French Fries")).click();
        $(".Stepper__ValueButton-sc-ho8tch-2", 1).click();
        $(".Stepper__QuantityBubble-sc-ho8tch-8").shouldHave(Condition.text("2"));
        $(".ProductViewFooter__SubmitButtonContent-sc-34t03j-5").shouldHave(Condition.text("Add to order"))
                .shouldHave(Condition.text("€6.00")).click();

        $(".CartViewButton__Price-sc-8iz5bz-2").shouldHave(Condition.text("€20.00"));

        $$(".Categories-module__categoryLink___WM_5v").find(Condition.text("DRINKS")).shouldHave(Condition.text("DRINKS")).click();
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text("Coca Cola"))
                .shouldHave(Condition.text("Coca Cola")).click();
        $(".ProductViewFooter__SubmitButtonContent-sc-34t03j-5").shouldHave(Condition.text("Add to order"))
                .shouldHave(Condition.text("€1.50")).click();


        $(".CartViewButton__Count-sc-8iz5bz-1").shouldHave(Condition.text("4"));
        $(".CartViewButton__Price-sc-8iz5bz-2").shouldHave(Condition.text("€21.50"));
    }
}
