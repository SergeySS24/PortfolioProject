package com.wolt.TestsSupport.TestsBase;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Base2 {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        open("https://wolt.com/en/cyp");
        $(".sc-3acf7193-0").$(".sc-eeff252-2").click();
        $(".Lgs3k4").click();

        $(".sc-8b48855d-0").click();
        $(".sc-8b48855d-0").setValue("353, 28th October Street");
        $$(".Popover__Content-sc-mo27do-2").findBy(Condition.text("28th October Avenue 353")).shouldBe(Condition.visible).click();
        webdriver().shouldHave(url("https://wolt.com/en/discovery"));
        $(".AddressSelectButton__AddressText-sc-1blbr80-3").shouldHave(Condition.text("28 October Avenue 353"));
    }

}
