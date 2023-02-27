package com.wolt.TestsSupport.TestsBase;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Base4 {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        open("https://wolt.com/en/cyp");
        $(".sc-3acf7193-0").$(".sc-eeff252-2").click();
        $(".Lgs3k4").click();
    }

}
