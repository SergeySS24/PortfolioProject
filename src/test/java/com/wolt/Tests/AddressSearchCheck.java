package com.wolt.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddressSearchCheck extends Base {

    @Test
    void addressSuggestionCheck() {
        $(".Input__InputComponent-sc-cy5jpp-0").setValue("353, 28th October Street");
        $(".Input__Label-sc-cy5jpp-4").shouldHave(Condition.text("Choose a delivery address"));
        $(".FrontPageLocationSelector-module__addressIcon___XlYcG")
                .shouldHave(Condition.attribute("xmlns", "http://www.w3.org/2000/svg"));
        $$(".Popover__Content-sc-mo27do-2").filterBy(Condition.text("28th October Avenue 353"))
                        .shouldHave(CollectionCondition.texts("28th October Avenue 353"));
    }

}
