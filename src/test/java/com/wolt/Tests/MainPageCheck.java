package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPageCheck extends Base {

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
    void pictureCheck() {


               // .shouldHave(Condition.attribute("img", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));

                        //.find(Condition.attribute("img src", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));

      $(".CountryFrontHeroBanner-module__root___txolf").$("img")
              .shouldHave(Condition.image);

             // .shouldHave(Condition.image);

                //.$(".img src")
               // .shouldHave(Condition.attributeMatching("img src", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));


       // $("image")
              //  .shouldBe(Condition.image"https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg");
    }




    @Test
    void dynamicWordsCheck() {
        $(".DefaultPageTemplate__MainContent-sc-kc7zgd-1").$(".header_words_animated_")
                .$(".CountryFrontHeroBanner-module__content___ZEhFp")
                .shouldHave(Condition.attribute("style", "animation-delay: 0s;"));
    }


}
