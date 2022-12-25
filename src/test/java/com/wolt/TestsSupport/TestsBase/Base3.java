package com.wolt.TestsSupport.TestsBase;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Base3 {

    @BeforeEach
     void setUp() {
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        open("https://wolt.com/en/cyp");
        $(".ConsentsBanner__Root-sc-194d5oz-0").$(".Button__Root-sc-a3fg5q-2").click();
        $(".Button-module__button___WpJP1").click();

        $(".Input__InputComponent-sc-cy5jpp-0").click();
        $(".Input__InputComponent-sc-cy5jpp-0").setValue("353, 28th October Street");
        $$(".Popover__Content-sc-mo27do-2").findBy(Condition.text("28th October Avenue 353")).shouldBe(Condition.visible).click();
        webdriver().shouldHave(url("https://wolt.com/en/discovery"));
        $(".AddressSelectButton__AddressText-sc-1blbr80-3").shouldHave(Condition.text("28 October Avenue 353"));

        $(".SearchInput__Input-sc-1web0kr-2").setValue("The Smuggers");
        $(".SearchResultItem__Info-sc-1paxeg7-3").click();

    }
}