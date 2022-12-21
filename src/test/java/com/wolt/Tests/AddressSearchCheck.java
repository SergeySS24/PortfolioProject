package com.wolt.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AddressSearchCheck extends Base {


    //Checking that entered address is in the dropdown results field
    @Test
    void addressSuggestionCheck() {
        $(".Input__InputComponent-sc-cy5jpp-0").click();
        $(".Input__InputComponent-sc-cy5jpp-0").setValue("353, 28th October Street");
        $(".Input__Label-sc-cy5jpp-4").shouldHave(Condition.text("Choose a delivery address"));
        $(".FrontPageLocationSelector-module__addressIcon___XlYcG")
                .shouldHave(Condition.attribute("xmlns", "http://www.w3.org/2000/svg"));
        $$(".Popover__Content-sc-mo27do-2").filterBy(Condition.text("28th October Avenue 353"))
                        .shouldHave(CollectionCondition.texts("28th October Avenue 353"));
    }


    @Test
    void addressSearchCheck() {
        $(".Input__InputComponent-sc-cy5jpp-0").click();
        $(".Input__InputComponent-sc-cy5jpp-0").setValue("353, 28th October Street");
        $$(".Popover__Content-sc-mo27do-2").findBy(Condition.text("28th October Avenue 353")).shouldBe(Condition.visible).click();
        webdriver().shouldHave(url("https://wolt.com/en/discovery"));
        $(".AddressSelectButton__AddressText-sc-1blbr80-3").shouldHave(Condition.text("28 October Avenue 353"));
    }

}
