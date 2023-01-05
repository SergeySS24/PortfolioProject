package com.wolt.TestsSupport.TestsSupport;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthorizationPopupSupport {


    @Step ("Click on 'Sign Up' button")
    public AuthorizationPopupSupport signUpButtonClick() {
        $(".Button__Content-sc-a3fg5q-3").click();
        return this;
    }

    @Step ("Authorization popup is present")
    public AuthorizationPopupSupport authorizationPopupHeader(String header) {
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text(header))
                .shouldHave(Condition.text(header));
        return this;
    }

    @Step ("Google authorization")
    public AuthorizationPopupSupport googleAuthorization(String authorization) {
        $(".SocialLoginButton__Root-sc-m5y1u4-3").shouldHave(Condition.text(authorization));
        $(".SocialLoginButton__Root-sc-m5y1u4-3").shouldHave(Condition.attribute("type", "button"));
        return this;
    }

    @Step ("Apple authorization")
    public AuthorizationPopupSupport appleAuthorization(String authorization) {
        $(".SocialLoginButton__Root-sc-m5y1u4-3", 1).shouldHave(Condition.text(authorization));
        $(".SocialLoginButton__Root-sc-m5y1u4-3", 1).shouldHave(Condition.attribute("type", "button"));
        return this;
    }

    @Step ("Facebook authorization")
    public AuthorizationPopupSupport facebookAuthorization(String authorization) {
        $(".SocialLoginButton__Root-sc-m5y1u4-3", 2).shouldHave(Condition.text(authorization));
        $(".SocialLoginButton__Root-sc-m5y1u4-3", 2).shouldHave(Condition.attribute("type", "button"));
        $$(".MethodSelect__SocialLoginStatus-sc-1bkm6bi-6").find(Condition.text("To log in with Facebook, please "))
                .shouldHave(Condition.text("To log in with Facebook, please "));
        $$(".MethodSelect__SocialLoginStatus-sc-1bkm6bi-6").find(Condition.text("accept marketing cookies"))
                .shouldHave(Condition.text("accept marketing cookies"));
        return this;
    }

    @Step ("Email authorization")
    public AuthorizationPopupSupport emailAuthorization(String authorization) {
        $(".MethodSelect__EmailOptionTitle-sc-1bkm6bi-7").shouldHave(Condition.text("or log in with email"));
        $$(".Input__Label-sc-cy5jpp-4").find(Condition.text(authorization)).shouldHave(Condition.text(authorization));
        return this;
    }

    @Step ("Set value to the email field")
    public AuthorizationPopupSupport emailSetValue(String value) {
        $("#method-select-email").setValue(value);
        return this;
    }

    @Step ("Click on 'Next' button")
    public AuthorizationPopupSupport nextButtonClick() {
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text("Next"))
                .shouldHave(Condition.text("Next")).click();
        return this;
    }

    @Step ("Error message 1")
    public AuthorizationPopupSupport errorMessage1(String error) {
        $(".FieldErrorWrapper__ErrorMessage-sc-1s7mirc-0").shouldHave(Condition.text(error));
        return this;
    }

    @Step ("Error message 2")
    public AuthorizationPopupSupport errorMessage2(String error) {
        $$(".Alert__Content-sc-kau7g8-12").find(Condition.text(error))
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
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text(header))
                .shouldHave(Condition.text(header));
        return this;
    }

    @Step ("'Sent email' popup resend button")
    public AuthorizationPopupSupport sentPopupEmailResendButton(String text) {
        $$(".Button__Root-sc-a3fg5q-2").find(Condition.text(text))
                .shouldHave(Condition.text(text));
        $$(".Button__Root-sc-a3fg5q-2").find(Condition.attribute("type", "button"))
                .shouldHave(Condition.attribute("type", "button"));
        return this;
    }

    @Step ("'Sent email' popup information message")
    public AuthorizationPopupSupport sentPopupEmailInformationMessage(String email) {
        $(".EmailSent__SubTitle-sc-1yz7xhb-2")
                .shouldHave(Condition.text("We've just sent a sign-in link to " + email +". Please check your spam folder in case you didn't get the email."));
        return this;
    }


}
