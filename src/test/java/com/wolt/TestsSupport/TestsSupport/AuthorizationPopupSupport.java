package com.wolt.TestsSupport.TestsSupport;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthorizationPopupSupport {


    @Step ("Click on 'Sign Up' button")
    public AuthorizationPopupSupport signUpButtonClick() {
        $(".sc-eaf76a21-2 ").click();
        return this;
    }

    @Step ("Authorization popup is present")
    public AuthorizationPopupSupport authorizationPopupHeader(String header) {
        $$(".sc-90dfde35-0").find(Condition.text(header))
                .shouldHave(Condition.text(header));
        return this;
    }

    @Step ("Google authorization")
    public AuthorizationPopupSupport googleAuthorization(String authorization) {
        $(".sc-8ec1ba62-1").shouldHave(Condition.text(authorization));
        return this;
    }

    @Step ("Apple authorization")
    public AuthorizationPopupSupport appleAuthorization(String authorization) {
        $(".sc-8ec1ba62-1", 1).shouldHave(Condition.text(authorization));
        return this;
    }

    @Step ("Facebook authorization")
    public AuthorizationPopupSupport facebookAuthorization(String authorization) {
        $(".sc-8ec1ba62-1", 2).shouldHave(Condition.text(authorization));
        $$(".sc-90dfde35-0").find(Condition.text("To log in with Facebook, please "))
                .shouldHave(Condition.text("To log in with Facebook, please "));
        $$(".sc-90dfde35-0").find(Condition.text("accept marketing cookies"))
                .shouldHave(Condition.text("accept marketing cookies"));
        return this;
    }

    @Step ("Email authorization")
    public AuthorizationPopupSupport emailAuthorization(String authorization) {
        $(".sc-90dfde35-0").shouldHave(Condition.text("or log in with email"));
        $$(".sc-8b48855d-1").find(Condition.text(authorization)).shouldHave(Condition.text(authorization));
        return this;
    }

    @Step ("Set value to the email field")
    public AuthorizationPopupSupport emailSetValue(String value) {
        $("#method-select-email").setValue(value);
        return this;
    }

    @Step ("Click on 'Next' button")
    public AuthorizationPopupSupport nextButtonClick() {
        $$(".sc-eeff252-2").find(Condition.text("Next"))
                .shouldHave(Condition.text("Next")).click();
        return this;
    }

    @Step ("Error message 1")
    public AuthorizationPopupSupport errorMessage1(String error) {
        $(".sc-fd1b4e4d-0").shouldHave(Condition.text(error));
        return this;
    }

    @Step ("Error message 2")
    public AuthorizationPopupSupport errorMessage2(String error) {
        $$(".sc-c8c7f0b8-12").find(Condition.text(error))
                .shouldHave(Condition.text(error));
        return this;
    }

    @Step ("Enter email value")
    public AuthorizationPopupSupport enterEmailValue(String value) {
        $("#method-select-email").setValue(value).pressEnter();
        return this;
    }

    @Step ("'Sent email' popup header")
    public AuthorizationPopupSupport sentPopupEmailHeader(String header) {
        $$(".sc-90dfde35-0").find(Condition.text(header))
                .shouldHave(Condition.text(header));
        return this;
    }

    @Step ("'Sent email' popup resend button")
    public AuthorizationPopupSupport sentPopupEmailResendButton(String text) {
        $$(".sc-eeff252-3").find(Condition.text(text))
                .shouldHave(Condition.text(text));
        return this;
    }

    @Step ("'Sent email' popup information message")
    public AuthorizationPopupSupport sentPopupEmailInformationMessage(String email) {
        $(".sc-8065770a-2")
                .shouldHave(Condition.text("We've just sent a sign-in link to " + email +". Please check your spam folder in case you didn't get the email."));
        return this;
    }


}
