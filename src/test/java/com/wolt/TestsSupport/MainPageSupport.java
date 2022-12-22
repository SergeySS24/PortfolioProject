package com.wolt.TestsSupport;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.restassured.RestAssured.given;

public class MainPageSupport {

    @Step ("Check that API request to the selected link returns code 200")
    public MainPageSupport status200Link(String link) {
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

    @Step ("Scroll to video container")
    public MainPageSupport videoContainerScroll() {
        $(".HalfVideo__Container-sc-1oodkf4-1").scrollTo().shouldHave(Condition.text("What is Wolt?"));
        return this;
    }

    @Step ("Video container has text")
    public MainPageSupport videoContainer(String text) {
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Play button has text")
    public MainPageSupport playButtonText(String text) {
        $(".PlayButton__Text-sc-1dcwfel-0").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Video container has jpeg poster")
    public MainPageSupport videoContainerJpgPoster(String poster) {
        $(".HalfVideo-module__video___lQp97")
                .shouldHave(Condition.attribute("poster", poster));
        return this;
    }

    @Step ("Video container has mp4 video")
    public MainPageSupport videoContainerMp4Video(String video) {
        $(".HalfVideo-module__video___lQp97")
                .shouldHave(Condition.attribute("src", video));
        return this;
    }

    @Step ("Play button click")
    public MainPageSupport playButtonClick() {
        $(".PlayButton-module__icon___HZW3O").click();
        return this;
    }

    @Step ("Close button exists")
    public MainPageSupport closeButtonPresent() {
        $(".CloseButton-module__closeButton___cMirh").$(".CloseButton-module__closeIcon___vPEhM")
                .shouldHave(Condition.attribute("xmlns", "http://www.w3.org/2000/svg"));
        return this;
    }

    @Step ("Close button visible")
    public MainPageSupport closeButtonVisible() {
        $(".CloseButton-module__closeButton___cMirh").shouldBe(Condition.visible);
        return this;
    }

    @Step ("Close button click")
    public MainPageSupport closeButtonClick() {
        $(".CloseButton-module__closeButton___cMirh").$(".CloseButton-module__icon___Y7DJn").click();
        return this;
    }

    @Step ("Video container should be visible")
    public MainPageSupport videoContainerVisible() {
        $(".HalfVideo__Container-sc-1oodkf4-1").shouldBe(Condition.visible);
        return this;
    }

    @Step ("Middle text mudule container scroll")
    public MainPageSupport middleTextModuleScroll() {
        $(".TitleText-module__container___dWvWp").scrollTo();
        return this;
    }

    @Step ("Middle text mudule container has text")
    public MainPageSupport middleTextModuleText(String text) {
        $(".TitleText-sc-1njwnfm-0").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Interactive middle module scroll to")
    public MainPageSupport interactiveModuleScroll() {
        $(".GetWolt-module__root___k50dq").scrollTo();
        return this;
    }

    @Step ("Interactive middle module heading")
    public MainPageSupport interactiveModuleHeading(String heading) {
        $(".GetWolt-module__root___k50dq").shouldHave(Condition.text(heading));
        return this;
    }

    @Step ("Interactive middle module text")
    public MainPageSupport interactiveModuleText(String text) {
        $(".GetWolt-module__content___r26Er").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Interactive middle module has Apple Store icon link")
    public MainPageSupport interactiveModuleAppleStoreLink() {
        $(".GetWolt-module__platformBadge___WDUQa")
                .shouldHave(Condition.href("https://wolt.onelink.me/Uy67?pid=not-available-web-to-app&c=not-available-" +
                        "web-to-app&af_adset=not-available-web-to-app&af_keywords=" +
                        "not-available-web-to-app&af_sub1=not-available-web-to-app&af_sub2=%2Fen%2Fcyp&af_r=https%3A%2F%2Fitunes" +
                        ".apple.com%2Ffi%2Fapp%2Fwolt%2Fid943905271%3Fmt%3D8"));
        return this;
    }

    @Step ("Interactive middle module has GooglePlay Store icon link")
    public MainPageSupport interactiveModuleGooglePlayLink() {
        $(".GetWolt-module__platformBadge___WDUQa", 1)
                .shouldHave(Condition.href("https://wolt.onelink.me/Uy67?pid=not-available-web-to-app&c=not-available" +
                        "-web-to-app&af_adset=not-available-web-to-app&af_keywords=not-available-web-to-app&af_sub1=not" +
                        "-available-web-to-app&af_sub2=%2Fen%2Fcyp&af_r=https%3A%2F%2Fplay.google.com%2" +
                        "Fstore%2Fapps%2Fdetails%3Fid%3Dcom.wolt.android"));
        return this;
    }

    @Step ("Interactive middle mudule background")
    public MainPageSupport interactiveModuleBackground() {
        $(".GetWolt-module__phonesImage___vGI3v")
                .shouldHave(Condition.attribute("src", "https://consumer-static-assets.wolt.com/frontpage-assets/front-cells.png"));
        return this;
    }

    @Step ("Suggestion section scroll to")
    public MainPageSupport suggestionSectionScroll() {
        $(".CardRow__Title-sc-36zoul-1").scrollTo();
        return this;
    }

    @Step ("Suggestion section heading")
    public MainPageSupport suggestionSectionHeading(String text) {
        $(".CardRow__Title-sc-36zoul-1").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Suggestion section 1 text")
    public MainPageSupport suggestionSection1Text(String text) {
        $(".Card-module__pad___nryOm").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Suggestion section 1 'Apply now'")
    public MainPageSupport suggestionSection1ApplyNow(String text) {
        $(".LinkButton__StyledAnchor-sc-7867te-0").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Suggestion section 1 'Apply now' link")
    public MainPageSupport suggestionSection1ApplyLink(String link) {
        $(".LinkButton__StyledAnchor-sc-7867te-0").shouldHave(Condition.href(link));
        return this;
    }

    @Step ("Suggestion section 2 text")
    public MainPageSupport suggestionSection2Text(String text) {
        $(".Card__Root-sc-1wsaipe-0", 1).shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Suggestion section 2 'Apply now'")
    public MainPageSupport suggestionSection2ApplyNow(String text) {
        $(".LinkButton__StyledAnchor-sc-7867te-0", 1).shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Suggestion section 2 'Apply now' link")
    public MainPageSupport suggestionSection2ApplyLink(String link) {
        $(".LinkButton__StyledAnchor-sc-7867te-0", 1).shouldHave(Condition.href(link));
        return this;
    }

    @Step ("Suggestion section 3 text")
    public MainPageSupport suggestionSection3Text(String text) {
        $(".Card__Root-sc-1wsaipe-0", 2).shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Suggestion section 3 'Apply now'")
    public MainPageSupport suggestionSection3ApplyNow(String text) {
        $(".LinkButton__StyledAnchor-sc-7867te-0", 2).shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Suggestion section 3 'Apply now' link")
    public MainPageSupport suggestionSection3ApplyLink(String link) {
        $(".LinkButton__StyledAnchor-sc-7867te-0", 2).shouldHave(Condition.href(link));
        return this;
    }
















}
