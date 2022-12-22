package com.wolt.TestsSupport;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.restassured.RestAssured.given;

public class MainPageSupport {

    @Step ("Check that API request to the selected link returns code 200")
    public MainPageSupport mainPageLinkStatus200(String link) {
        given()
                .get(link)
                .then()
                .statusCode(200);
        return this;
    }

    @Step ("Click on 'Wolt' logo")
    public MainPageSupport logoClick() {
        $(".MainHeader__LogoLink-sc-5qxwnz-2").click();
        return this;
    }

    @Step ("Authorization section")
    public MainPageSupport authorizationSection(String value) {
        $(".MainHeader__RightCol-sc-5qxwnz-5").shouldHave(Condition.text(value));
        return this;
    }

    @Step ("Click on 'Log in' button")
    public MainPageSupport logInClick() {
        $(".TextButton__Root-sc-1r17c4e-0").click();
        return this;
    }

    @Step ("Authorization popup")
    public MainPageSupport authorizationPopup(String text) {
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text(text))
                .shouldHave(Condition.text(text));
        return this;
    }


    @Step ("'Next' button should have 'button' attribute")
    public MainPageSupport nextButton() {
        $(".Button__Root-sc-a3fg5q-2").shouldHave(Condition.attribute("role", "button"));
        return this;
    }

    @Step ("Click on 'Sign up' button")
    public MainPageSupport signUpButtonClick() {
        $(".Button__Content-sc-a3fg5q-3").click();
        return this;
    }

    @Step ("Heading above the search field check")
    public MainPageSupport searchFieldHeading(String text) {
        $(".CountryFrontHeroBanner-module__addressLabel___GPvr0").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Search field check")
    public MainPageSupport searchField(String text) {
        $(byXpath("//*[@id='mainContent']/div/div[1]/div/div[2]/div[2]/div/div/label")).shouldHave(Condition.text(text));
        return this;
    }

    @Step ("'Explore citied' heading")
    public MainPageSupport exploreCitiesHeading(String text) {
        $(byXpath("//*[@id='mainContent']/div/section")).shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Displaying selected country")
    public MainPageSupport selectedCountrtDisplay(String country) {
        $(".SideNav-module__sideNavigationTitle___BELWP").shouldHave(Condition.text(country));
        return this;
    }

    @Step ("Section with all cities")
    public MainPageSupport allCitiesSection(String city) {
        $$(".CitySelection-module__contentWrapper___BWfyh").find(Condition.text(city)).shouldBe(Condition.visible);
        return this;
    }











}
