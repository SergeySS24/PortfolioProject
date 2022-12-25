package com.wolt.TestsSupport.TestsBase;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Base {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        open("https://wolt.com/en/cyp");
        $(".ConsentsBanner__Root-sc-194d5oz-0").$(".Button__Root-sc-a3fg5q-2").click();
        $(".Button-module__button___WpJP1").click();
    }

}
