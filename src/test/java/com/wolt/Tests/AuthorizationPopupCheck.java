package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.wolt.TestsSupport.Base;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPopupCheck extends Base {

    Faker faker = new Faker();

    public final String email = faker.internet().emailAddress();

    @Test
    void googleVerificationCheck() {
        $(".Button__Content-sc-a3fg5q-3").click();
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text("Create an account or log in"))
                .shouldHave(Condition.text("Create an account or log in"));
        $(".SocialLoginButton__Root-sc-m5y1u4-3").shouldHave(Condition.text("Continue with Google"));
        $(".SocialLoginButton__Root-sc-m5y1u4-3").shouldHave(Condition.attribute("type", "button"));
    }


    @Test
    void appleVerificationCheck() {
        $(".Button__Content-sc-a3fg5q-3").click();
        $(".SocialLoginButton__Root-sc-m5y1u4-3", 1).shouldHave(Condition.text("Continue with Apple"));
        $(".SocialLoginButton__Root-sc-m5y1u4-3", 1).shouldHave(Condition.attribute("type", "button"));
    }


    @Test
    void facebookVerificationCheck() {
        $(".Button__Content-sc-a3fg5q-3").click();
        $(".SocialLoginButton__Root-sc-m5y1u4-3", 2).shouldHave(Condition.text("Continue with Facebook"));
        $(".SocialLoginButton__Root-sc-m5y1u4-3", 2).shouldHave(Condition.attribute("type", "button"));
        $$(".MethodSelect__SocialLoginStatus-sc-1bkm6bi-6").find(Condition.text("To log in with Facebook, please "))
                .shouldHave(Condition.text("To log in with Facebook, please "));
        $$(".MethodSelect__SocialLoginStatus-sc-1bkm6bi-6").find(Condition.text("accept marketing cookies"))
                .shouldHave(Condition.text("accept marketing cookies"));
    }


    @Test
    void emailVerificationCheck() {
        $(".Button__Content-sc-a3fg5q-3").click();
        $(".MethodSelect__EmailOptionTitle-sc-1bkm6bi-7").shouldHave(Condition.text("or log in with email"));
        $$(".Input__Label-sc-cy5jpp-4").find(Condition.text("Email")).shouldHave(Condition.text("Email"));
    }


    @Test
    void emailErrorMessageCheck() {
        $(".Button__Content-sc-a3fg5q-3").click();
        $("#method-select-email").setValue("dqwd");
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text("Next"))
                .shouldHave(Condition.text("Next")).click();
        $(".FieldErrorWrapper__ErrorMessage-sc-1s7mirc-0").shouldHave(Condition.text("Please enter a valid email."));
    }


    @Test
    void sendEmailCheck() {
        $(".Button__Content-sc-a3fg5q-3").click();
        $("#method-select-email").setValue(email).pressEnter();
        $(".AuthModal__ScreenWrapper-sc-1u3qek0-0").shouldBe(Condition.visible);
        sleep(7000);
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text("Great, check your inbox!"))
                .shouldHave(Condition.text("Great, check your inbox!"));


    }
}
