package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import com.wolt.TestsSupport.AuthorizationPopupSupport;
import com.wolt.TestsSupport.Base;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPopupCheck extends Base {

    Faker faker = new Faker();

    public final String email = faker.internet().emailAddress();

    AuthorizationPopupSupport step = new AuthorizationPopupSupport();

    @Test
    void googleVerificationCheck() {
        step.signUpButtonClick()
                .authorizationPopupHeader("Create an account or log in")
                .googleAuthorization("Continue with Google");
    }


    @Test
    void appleVerificationCheck() {
        step.signUpButtonClick()
                .appleAuthorization("Continue with Apple");
    }


    @Test
    void facebookVerificationCheck() {
        step.signUpButtonClick()
                .facebookAuthorization("Continue with Facebook");
    }


    @Test
    void emailVerificationCheck() {
        step.signUpButtonClick()
                .emailAuthorization("Email");
    }


    @Test
    void emailErrorMessageCheck1() {
        step.signUpButtonClick()
                .emailSetValue("dqwd")
                .nextButtonClick()
                .errorMessage1("Please enter a valid email.");
    }


    @Test
    void emailErrorMessageCheck2() {
        step.signUpButtonClick()
                .enterEmailValue("sergey.ss@fqwfwoe.ter");
        sleep(7000);
        step.errorMessage2("Invalid parameters.");
    }


    @Test
    void sendEmailCheck() {
        step.signUpButtonClick()
                .enterEmailValue(email);
        sleep(7000);
        step.sentPopupEmailHeader("Great, check your inbox!")
                .sentPopupEmailResendButton("Resend email")
                .sentPopupEmailInformationMessage(email);

//
//        $(".Button__Content-sc-a3fg5q-3").click();
//        $("#method-select-email").setValue(email).pressEnter();
//        sleep(7000);
//        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text("Great, check your inbox!"))
//                .shouldHave(Condition.text("Great, check your inbox!"));
//        $$(".Button__Root-sc-a3fg5q-2").find(Condition.text("Resend email"))
//                .shouldHave(Condition.text("Resend email"));
//
//        $(".EmailSent__SubTitle-sc-1yz7xhb-2")
//                .shouldHave(Condition.text("We've just sent a sign-in link to " + email +". Please check your spam folder in case you didn't get the email."));
//        $$(".Button__Root-sc-a3fg5q-2").find(Condition.attribute("type", "button"))
//                .shouldHave(Condition.attribute("type", "button"));
    }
}
