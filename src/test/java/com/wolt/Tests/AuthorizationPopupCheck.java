package com.wolt.Tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.wolt.TestsSupport.TestsBase.Base4;
import com.wolt.TestsSupport.TestsSupport.AuthorizationPopupSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPopupCheck extends Base4 {

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
    }

    @AfterEach
    public void finish() {
        Selenide.refresh();
    }

}
