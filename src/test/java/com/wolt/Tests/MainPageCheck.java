package com.wolt.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base;
import com.wolt.TestsSupport.Cities1;
import com.wolt.TestsSupport.Cities2;
import org.junit.jupiter.api.Assertions;
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
    void citiesHeading(){
        $(".CitySelection-module__container___xXS1B").shouldHave(Condition.text("Explore cities where you find Wolt"));
        //$(".SideNav-module__sideNavigationTitle___BELWP").shouldHave(Condition.text("Cyprus"));

        Assertions.assertEquals("Cyprus", $(".SideNav-module__sideNavigationTitle___BELWP"));

        $$(".CitySelection-module__contentWrapper___BWfyh").first().shouldHave(Condition.text("Ammochostos"));

        $$(".CitySelection-module__contentWrapper___BWfyh").shouldHave(); //можно подставить цикл for
    }


    @EnumSource(Cities2.class)
    @ParameterizedTest(name = "Checking all cities on the main page")
    void checkCities(Cities2 allCities) {
        $$(".CitySelection-module__contentWrapper___BWfyh").find(Condition.text(allCities.city)).shouldBe(Condition.visible);
    }


    @Test
    void discoverBannerCheckHeadingPictureVideo() {
        $(".HalfVideo__Container-sc-1oodkf4-1").scrollTo().shouldHave(Condition.text("What is Wolt?"));
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text("Delivered."));
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text("Wolt makes it incredibly easy for"));
        $(".PlayButton-module__icon___HZW3O").$(".PlayButton-module__playIcon___bd0jC")
                .shouldHave(Condition.attribute("xmlns", "http://www.w3.org/2000/svg"));
        $(".PlayButton__Text-sc-1dcwfel-0").shouldHave(Condition.text("Watch video"));
        $(".HalfVideo-module__video___lQp97")
                .shouldHave(Condition.attribute("poster",
                        "https://consumer-static-assets.wolt.com/frontpage-assets/video-cover-image-4.jpg"));
        $(".HalfVideo-module__video___lQp97")
                .shouldHave(Condition.attribute("src",
                        "https://consumer-static-assets.wolt.com/frontpage-assets/Wolt_Brand_Film_2020.mp4"));
    }


    @Test
    void discoverBannerPlayButtonXbuttonPresent() { //Нужен ли этот тест?
        $(".HalfVideo__Container-sc-1oodkf4-1").scrollTo();
        $(".PlayButton-module__icon___HZW3O").click();
        sleep(1000);
        $(".CloseButton-module__closeButton___cMirh").$(".CloseButton-module__closeIcon___vPEhM")
         .shouldHave(Condition.attribute("xmlns", "http://www.w3.org/2000/svg"));
    }


    @Test
    void discoverBannerPlayButtonClick() {
        $(".HalfVideo__Container-sc-1oodkf4-1").scrollTo();
        $(".PlayButton-module__icon___HZW3O").click();
        //sleep(3000);
        $(".CloseButton-module__closeButton___cMirh").shouldBe(Condition.visible);
        $(".CloseButton-module__closeButton___cMirh").$(".CloseButton-module__icon___Y7DJn").click();
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldBe(Condition.visible);
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text("What is Wolt?"));
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text("Delivered."));
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text("Wolt makes it incredibly easy for"));
        $(".PlayButton-module__icon___HZW3O").$(".PlayButton-module__playIcon___bd0jC")
                .shouldHave(Condition.attribute("xmlns", "http://www.w3.org/2000/svg"));
        $(".PlayButton__Text-sc-1dcwfel-0").shouldHave(Condition.text("Watch video"));
    }


    @Test
    void discoverBannerTextLink() {
        $(".HalfVideo__Container-sc-1oodkf4-1").scrollTo();
        $(".PlayButton__Text-sc-1dcwfel-0").click();
        ///sleep(3000);
        $(".CloseButton-module__closeButton___cMirh").shouldBe(Condition.visible);
        $(".CloseButton-module__closeButton___cMirh").$(".CloseButton-module__icon___Y7DJn").click();
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldBe(Condition.visible);
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text("What is Wolt?"));
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text("Delivered."));
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text("Wolt makes it incredibly easy for"));
        $(".PlayButton-module__icon___HZW3O").$(".PlayButton-module__playIcon___bd0jC")
                .shouldHave(Condition.attribute("xmlns", "http://www.w3.org/2000/svg"));
        $(".PlayButton__Text-sc-1dcwfel-0").shouldHave(Condition.text("Watch video"));
    }


    @Test
    void middleTextModule() {
        $(".TitleText-module__container___dWvWp").scrollTo();
        $(".TitleText-sc-1njwnfm-0").shouldHave(Condition.text("Did you know?"));
        $(".TitleText-sc-1njwnfm-0").shouldHave(Condition.text("Getting home-delivered sushi is more than"));
    }


    @Test
    void interactiveMiddleModule() {
        $(".GetWolt-module__root___k50dq").scrollTo().shouldHave(Condition.text("Honey, we’re not cooking tonight"));
        $(".GetWolt-module__content___r26Er").shouldHave(Condition.text("Get the Apple-awarded Wolt app and choose from 40,000"));
    }
}


