package com.wolt.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Login {

    @BeforeAll
    static void preparation() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void login() {
        open("https://wolt.com/en/cyp");
        $(".ConsentsBanner__Root-sc-194d5oz-0").$(".Button__Root-sc-a3fg5q-2").click();
        $(".Button-module__button___WpJP1").click();
    }






    @Test
    void switchToLimassol() {
        open("https://wolt.com/en/cyp");
        $(".ConsentsBanner__Root-sc-194d5oz-0").$(".Button__Root-sc-a3fg5q-2").click();
        $(".Button-module__button___WpJP1").click();
        $(".CitySelection-module__container___xXS1B").scrollTo().shouldHave(Condition.text("Limassol"));
        $(".List-module__listOfCities____EgRr").$(".ListItem-module__container___ji0Cg", 2).click();
        $(".ControlledDeliveryLocationButton__LocationName-sc-124bug2-2").shouldHave(Condition.text("Limassol"));
    }

    @Test
    void locationChangePopup() {

        open("https://wolt.com/en/cyp");
        $(".ConsentsBanner__Root-sc-194d5oz-0").$(".Button__Root-sc-a3fg5q-2").click();
        $(".Button-module__button___WpJP1").click();
        $(".CitySelection-module__container___xXS1B").scrollTo().shouldHave(Condition.text("Limassol"));
        $(".List-module__listOfCities____EgRr").$(".ListItem-module__container___ji0Cg", 2).click();
        $(".ControlledDeliveryLocationButton__LocationName-sc-124bug2-2").shouldHave(Condition.text("Limassol"));

        $(".Popover__Root-sc-mo27do-0")
                .shouldHave(Condition.text("You can change your delivery location here. Happy Wolting \uD83D\uDC99"));
    }


}
