package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.wolt.TestsSupport.Base;
import com.wolt.TestsSupport.Cities2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;


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
        $(".MainHeader__RightCol-sc-5qxwnz-5")
                .shouldHave(Condition.text("Log in"));
    }

    @Test
    void loginElementClick() {
        $(".TextButton__Root-sc-1r17c4e-0").click();
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text("Create an account or log in"))
                .shouldHave(Condition.text("Create an account or log in"));
     }


    @Test
    void loginElementClickNextutton() {
        $(".TextButton__Root-sc-1r17c4e-0").click();
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text("Next"))
                .shouldHave(Condition.text("Next"));
        $(".Button__Root-sc-a3fg5q-2").shouldHave(Condition.attribute("role", "button"));
    }

    @Test
    void signUpElementPresent() {
        $(".biJhpz")
                .shouldHave(Condition.text("Sign up"));
    }

    @Test
    void sighUpElementClick() {
        $(".Button__Content-sc-a3fg5q-3").click();
        $$(".AuthModal__ScreenWrapper-sc-1u3qek0-0").find(Condition.text("Create an account or log in"))
                .shouldHave(Condition.text("Create an account or log in"));
    }


    @Test
    void searchBarElementCheck() {
        $(".CountryFrontHeroBanner-module__addressLabel___GPvr0").shouldHave(Condition.text("Delivery address"));
        $(".Input__Label-sc-cy5jpp-4").shouldHave(Condition.text("Choose a delivery address"));
        $(".Button-module__button___WpJP1").shouldHave(Condition.attribute("type", "button"));
        $(".Button-module__button___WpJP1").shouldHave(Condition.text("Search"));
    }


    @Test
    void searchBarClick(){
        $(".Input__Root-sc-cy5jpp-1").click();
        $(".Popover__Content-sc-mo27do-2").shouldHave(Condition.text("Use my current location"));
        $(".Button-module__button___WpJP1").click();
        $(".Popover__Content-sc-mo27do-2").shouldHave(Condition.text("Use my current location"));
    }


    @Test
    void citiesHeading() {
        $(".CitySelection-module__container___xXS1B").shouldHave(Condition.text("Explore cities where you find Wolt"));
        $(".SideNav-module__sideNavigationTitle___BELWP").shouldHave(Condition.text("Cyprus"));
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
        $(".GetWolt-module__platformBadge___WDUQa")
                .shouldHave(Condition.href("https://wolt.onelink.me/Uy67?pid=not-available-web-to-app&c=not-available-" +
                        "web-to-app&af_adset=not-available-web-to-app&af_keywords=" +
                        "not-available-web-to-app&af_sub1=not-available-web-to-app&af_sub2=%2Fen%2Fcyp&af_r=https%3A%2F%2Fitunes" +
                        ".apple.com%2Ffi%2Fapp%2Fwolt%2Fid943905271%3Fmt%3D8"));
        $(".GetWolt-module__platformBadge___WDUQa", 1)
                .shouldHave(Condition.href("https://wolt.onelink.me/Uy67?pid=not-available-web-to-app&c=not-available" +
                        "-web-to-app&af_adset=not-available-web-to-app&af_keywords=not-available-web-to-app&af_sub1=not" +
                        "-available-web-to-app&af_sub2=%2Fen%2Fcyp&af_r=https%3A%2F%2Fplay.google.com%2" +
                        "Fstore%2Fapps%2Fdetails%3Fid%3Dcom.wolt.android"));
        $(".GetWolt-module__phonesImage___vGI3v")
                .shouldHave(Condition.attribute("src", "https://consumer-static-assets.wolt.com/frontpage-assets/front-cells.png"));
    }


    @Test
    void suggestionSection1() {
        $(".CardRow__Title-sc-36zoul-1").scrollTo().shouldHave(Condition.text("Hungry for more than food?"));
        $(".Card-module__img___NhWat").shouldHave(Condition.attribute("style"));
        $(".Card-module__pad___nryOm").shouldHave(Condition.text("Get paid as a courier partner"));
        $(".LinkButton__StyledAnchor-sc-7867te-0").shouldHave(Condition.text("Apply now"));
        $(".LinkButton__StyledAnchor-sc-7867te-0").shouldHave(Condition.href("https://explore.wolt.com/en/cyp/couriers"));
        $(".LinkButton__StyledAnchor-sc-7867te-0").click();
        webdriver().shouldHave(url("https://explore.wolt.com/en/cyp/couriers"));
        Selenide.back();
    }


    @Test
    void suggestionSection2() {
        $(".CardRow__Title-sc-36zoul-1").scrollTo();
        $(".Card__Root-sc-1wsaipe-0", 1).shouldHave(Condition.text("Serve more people as a restaurant partner"));
        $(".Card-module__img___NhWat", 1).shouldHave(Condition.attribute("style"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 1).shouldHave(Condition.text("Apply now"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 1).shouldHave(Condition.href("/en/merchants"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 1).click();
        webdriver().shouldHave(url("https://wolt.com/en/merchants"));
        Selenide.back();
    }


    @Test
    void suggestionSection3() {
        $(".CardRow__Title-sc-36zoul-1").scrollTo();
        $(".Card__Root-sc-1wsaipe-0", 2).shouldHave(Condition.text("Enter a new chapter and find a job at Wolt"));
        $(".Card-module__img___NhWat", 2).shouldHave(Condition.attribute("style"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 2).shouldHave(Condition.text("Apply now"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 2).shouldHave(Condition.href("/en/jobs"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 2).click();
        webdriver().shouldHave(url("https://wolt.com/en/jobs"));
        Selenide.back();
    }

    @Test
    void footerAppStoreCheck() {
        $("#footer").scrollTo();
        $(".Footer__AppLink-sc-1ki6z7e-11")
                .shouldHave(Condition.href("https://wolt.onelink.me/Uy67?pid=not-available-web-to-app&c=not-available-" +
                        "web-to-app&af_adset=not-available-web-to-app&af_keywords=not-available-web-to-app&af_sub1=not-" +
                        "available-web-to-app&af_sub2=%2Fen%2Fcyp&af_r=https%3A%2F%2Fitunes.apple.com%2Ffi%2Fapp%2Fwolt%2Fid943905271%3Fmt%3D8"));
        $(".Footer__AppLink-sc-1ki6z7e-11").shouldHave(Condition.attribute("title",
                "Download the Wolt iOS app on the App Store"));
    }


    @Test
    void footerGooglePlayCheck() {
        $("#footer").scrollTo();
        $(".Footer__AppLink-sc-1ki6z7e-11", 1)
                .shouldHave(Condition.href("https://wolt.onelink.me/Uy67?pid=not-available-web-to-app&c=not-available-" +
                        "web-to-app&af_adset=not-available-web-to-app&af_keywords=not-available-web-to-app&af_sub1=not-" +
                        "available-web-to-app&af_sub2=%2Fen%2Fcyp&af_r=https%3A%2F%2Fplay.google.com%2Fstore%2Fapps%2Fdetails%3Fid%3Dcom.wolt.android"));
        $(".Footer__AppLink-sc-1ki6z7e-11", 1).shouldHave(Condition.attribute("title",
                "Download the Wolt Android app on Google Play"));
    }


    //checking first footer column
    @ValueSource(strings = {
            "For couriers",
            "For restaurants",
            "For stores",
            "For companies",
            "Wolt Drive"
    })

    @ParameterizedTest(name = "checking first footer colomn for word {0}")
    void firstFooterColumnCheck(String testData) {
        $("#footer").scrollTo();
        $("#FooterLinkGroup-Title-1").shouldHave(Condition.text("Let's do this together"));

        $(".FooterLinkGroup__Content-sc-1vexfqi-2").shouldHave(Condition.text(testData));
    }


    @Test
    void firstFooterColomnLinkCheck() {
        $("#footer").scrollTo();
        $(".Footer__Link-sc-1ki6z7e-18").shouldHave(Condition.href("https://explore.wolt.com/en/cyp/couriers"));
        $(".Footer__Link-sc-1ki6z7e-18", 1).shouldHave(Condition.href("/en/merchants"));
        $(".Footer__Link-sc-1ki6z7e-18", 2).shouldHave(Condition.href("/en/retailers"));
        $(".Footer__Link-sc-1ki6z7e-18", 3).shouldHave(Condition.href("/en/wolt-at-work"));
        $(".Footer__Link-sc-1ki6z7e-18", 4).shouldHave(Condition.href("/en/drive"));
    }


    //checking second footer column
    @ValueSource(strings = {
            "About us",
            "Jobs",
            "Responsibility",
            "Security",
            "Investors"
    })

    @ParameterizedTest(name = "checking second footer column for word {0}")
    void secondFooterColumnCheck(String testData) {
        $("#footer").scrollTo();
        $("#FooterLinkGroup-Title-2").shouldHave(Condition.text("Company"));

        $(".FooterLinkGroup__Content-sc-1vexfqi-2", 1).shouldHave(Condition.text(testData));
    }


    //checking third footer column
    @ValueSource(strings = {
            "Support",
            "Media",
            "Contact"
    })

    @ParameterizedTest(name = "checking third footer column for word {0}")
    void thirdFooterColumnCheck(String testData) {
        $("#footer").scrollTo();
        $("#FooterLinkGroup-Title-3").shouldHave(Condition.text("Useful links"));

        $(".FooterLinkGroup__Content-sc-1vexfqi-2", 2).shouldHave(Condition.text(testData));
    }


    //checking fourth footer column
    @ValueSource(strings = {
            "Wolt blog",
            "Engineering blog",
            "Instagram",
            "Facebook",
            "Twitter",
            "LinkedIn"
    })

    @ParameterizedTest(name = "checking fourth footer column for word {0}")
    void fourthFooterColumnCheck(String testData) {
        $("#footer").scrollTo();
        $("#FooterLinkGroup-Title-4").shouldHave(Condition.text("Follow us"));

        $(".FooterLinkGroup__Content-sc-1vexfqi-2", 3).shouldHave(Condition.text(testData));
    }


    @Test
    void bottomBarOne() {
        $("#footer").scrollTo();
        $(".FooterSettingButton__Root-sc-1nledng-0").shouldHave(Condition.text("Cyprus"));
        $(".FooterSettingButton__Root-sc-1nledng-0", 1).shouldHave(Condition.text("English"));
        $(".FooterSettingButton__Root-sc-1nledng-0", 2).shouldHave(Condition.text("Accessibility"));
    }


    @Test
    void bottomBarTwo() {
        $("#footer").scrollTo();
        $(".Footer__BottomLink-sc-1ki6z7e-7").shouldHave(Condition.text("Accessibility Statement"));
        $(".Footer__BottomLink-sc-1ki6z7e-7", 1).shouldHave(Condition.text("Terms and Conditions"));
        $(".Footer__BottomLink-sc-1ki6z7e-7", 2).shouldHave(Condition.text("Privacy Policy"));

        $(".Footer__Attribution-sc-1ki6z7e-8").shouldHave(Condition.text("©️ Wolt 2014–2022"));
    }

}





