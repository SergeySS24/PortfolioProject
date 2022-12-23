package com.wolt.TestsSupport;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MakingOrderSupport {

    @Step("Add extra item to the selected product")
    public MakingOrderSupport addExtraItem(String item) {
        $$(".Checkboxes__CheckboxWrapper-sc-1skk1h0-0").find(Condition.text(item))
                .shouldHave(Condition.text(item)).click();
        return this;
    }

    @Step("Add extra items count check")
    public MakingOrderSupport addExtraItemCounter(String text) {
        $(".Options__OptionDescription-sc-1yd6u15-7").shouldHave(Condition.text(text));
        return this;
    }

    @Step("Submit button check")
    public MakingOrderSupport submitButtonTotalPrice(String price) {
        $(".ProductViewFooter__SubmitButtonContent-sc-34t03j-5").shouldHave(Condition.text("Add to order"))
                .shouldHave(Condition.text(price));
        return this;
    }

    @Step("Submit button check")
    public MakingOrderSupport submitButtonClick() {
        $(".ProductViewFooter__SubmitButtonContent-sc-34t03j-5").click();
        return this;
    }

    @Step("Ordered item has a number, indicating how many times it has been ordered")
    public MakingOrderSupport selectedItemOrderQuantity(String value) {
        $(".PlusCount__Label-sc-1mt4kjx-1").shouldHave(Condition.text(value));
        return this;
    }

    @Step("Total order price displayed")
    public MakingOrderSupport totalOrderPrice(String price) {
        $(".CartViewButton__Price-sc-8iz5bz-2").shouldHave(Condition.text(price));
        return this;
    }

    @Step("Total number of ordered items displayed")
    public MakingOrderSupport totalNumberOfOrderedItems(String number) {
        $(".CartViewButton__Count-sc-8iz5bz-1").shouldHave(Condition.text(number));
        return this;
    }

    @Step("Increase product quantity to order")
    public MakingOrderSupport itemQuantityIncrease() {
        $(".Stepper__ValueButton-sc-ho8tch-2", 1).click();
        return this;
    }

    @Step("Quantity of ordered item in the item card")
    public MakingOrderSupport itemQuantity(String value) {
        $(".Stepper__QuantityBubble-sc-ho8tch-8").shouldHave(Condition.text(value));
        return this;
    }








}

