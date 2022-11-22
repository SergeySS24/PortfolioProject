package com.wolt.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base;
import com.wolt.TestsSupport.Cities1;
import com.wolt.TestsSupport.Cities2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPageCheck extends Base {

    Cities1 s = new Cities1();

    @Test
    void woltLogoClick() {
        $(".MainHeader__LogoLink-sc-5qxwnz-2").click();
        webdriver().shouldHave(url("https://wolt.com/en/discovery"));
    }

    @Test
    void loginElementPresent() {
        $(".Header__AnimateToHiddenContainer-sc-1wbjs06-6")
                .shouldHave(Condition.text("Log in"));
    }

    @Test
    void loginElementClick() {
        $(".Header__AnimateToHiddenContainer-sc-1wbjs06-6").click();
        $(".MethodSelect__Titles-sc-1bkm6bi-1").shouldHave(Condition.text("Create an account or log in"));
    }

    @Test
    void signUpElementPresent() {
        $(".Header__AnimateToHiddenContainer-sc-1wbjs06-6")
                .shouldHave(Condition.text("Sign up"));
    }

    @Test
    void sighUpElementClick() {
        $(".Header__AnimateToHiddenContainer-sc-1wbjs06-6").click();
        $(".AuthModal__ScreenWrapper-sc-1u3qek0-0").shouldHave(Condition.text("Create an account or log in"));
    }


    @Test
    void dynamicWordsCheck() {
        $(".DefaultPageTemplate__MainContent-sc-kc7zgd-1").$(".header_words_animated_")
                .$(".CountryFrontHeroBanner-module__content___ZEhFp")
                .shouldHave(Condition.attribute("style", "animation-delay: 0s;"));
    }


    @Test
    void citiesHeading(String cities){
        $(".CitySelection-module__container___xXS1B").shouldHave(Condition.text("Explore cities where you find Wolt"));
        $(".SideNav-module__sideNavigationTitle___BELWP").shouldHave(Condition.text("Cyprus"));
        $$(".CitySelection-module__contentWrapper___BWfyh").first().shouldHave(Condition.text("Ammochostos"));
        $$(".CitySelection-module__contentWrapper___BWfyh").shouldHave();
        }


    @EnumSource(Cities2.class)
    @ParameterizedTest(name = "Checking all cities on the main page")
    void checkCities(Cities2 allCities) {
        $$(".CitySelection-module__contentWrapper___BWfyh").find(Condition.text(allCities.city)).shouldBe(Condition.visible);
    }


    @ValueSource(strings = {"Ammochostos", "Larnaca", "Limassol", "Nicosia", "Paphos"})
    @ParameterizedTest(name = "Check all cities")
    void checkTowns(String cities) {
        $$(".CitySelection-module__contentWrapper___BWfyh").find(Condition.text(cities)).shouldBe(Condition.visible);

    }

}


