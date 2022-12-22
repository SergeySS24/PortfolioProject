package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.wolt.TestsSupport.Base;
import com.wolt.TestsSupport.Cities2;
import com.wolt.TestsSupport.MainPageSupport;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPageCheck extends Base {

    MainPageSupport step = new MainPageSupport();

    @Test
    void woltLogoClick() {
        step.logoClick()
                .status200Link("https://wolt.com/en/discovery");
        webdriver().shouldHave(url("https://wolt.com/en/discovery"));
    }

    @Test
    void loginElementPresent() {
        step.authorizationSection("Log in");
    }

    @Test
    void loginElementClick() {
        step.logInClick()
                .authorizationPopup("Create an account or log in")
                .authorizationPopup("Next")
                .nextButton();
     }


    @Test
    void signUpElementPresent() {
        step.authorizationSection("Sign up");
    }

    @Test
    void sighUpElementClick() {
        step.signUpButtonClick()
                .authorizationPopup("Create an account or log in")
                .authorizationPopup("Next")
                .nextButton();
    }

    @Test
    void searchBarElementCheck() {
        step.searchFieldHeading("Delivery address")
                .searchField("Delivery address");
    }

    @Test
    void citiesHeading() {
        step.exploreCitiesHeading("Explore cities where you find Wolt")
                .selectedCountrtDisplay("Cyprus");
    }


    @EnumSource(Cities2.class)
    @ParameterizedTest(name = "Checking all cities on the main page")
    void checkCities(Cities2 allCities) {
        step.allCitiesSection(allCities.city);
    }

    @Test
    void discoverBannerCheckHeadingPictureVideo() {
        step.videoContainerScroll()
                .videoContainer("What is Wolt?")
                .videoContainer("Delivered.")
                .videoContainer("Wolt makes it incredibly easy for")
                .playButtonText("Watch video")
                .videoContainerJpgPoster("https://consumer-static-assets.wolt.com/frontpage-assets/video-cover-image-4.jpg")
                .videoContainerMp4Video("https://consumer-static-assets.wolt.com/frontpage-assets/Wolt_Brand_Film_2020.mp4");;
    }

    @Test
    void discoverBannerPlayButtonXbuttonPresent() {
        step.videoContainerScroll()
                .playButtonClick();
        sleep(1000);
                step.closeButtonPresent();
    }

    @Test
    void discoverBannerPlayButtonClick() {
        step.videoContainerScroll()
                .playButtonClick()
                .closeButtonVisible()
                .closeButtonClick()
                .videoContainerVisible()
                .videoContainer("What is Wolt?")
                .videoContainer("Delivered.")
                .videoContainer("Wolt makes it incredibly easy for")
                .playButtonText("Watch video");
    }

    @Test
    void middleTextModule() {
        step.middleTextModuleScroll()
                .middleTextModuleText("Did you know?")
                .middleTextModuleText("Getting home-delivered sushi is more than");
    }

    @Test
    void interactiveMiddleModule() {
        step.interactiveModuleScroll()
                .interactiveModuleHeading("Honey, we’re not cooking tonight")
                .interactiveModuleText("Get the Apple-awarded Wolt app and choose from 40,000")
                .interactiveModuleAppleStoreLink()
                .interactiveModuleGooglePlayLink()
                .interactiveModuleBackground()
                .status200Link("https://consumer-static-assets.wolt.com/frontpage-assets/front-cells.png");
    }

    @Test
    void suggestionSection1() {
        step.suggestionSectionScroll()
                .suggestionSectionHeading("Hungry for more than food?")
                .suggestionSection1Text("Get paid as a courier partner")
                .suggestionSection1ApplyNow("Apply now")
                .suggestionSection1ApplyLink("https://explore.wolt.com/en/cyp/couriers")
                .status200Link("https://explore.wolt.com/en/cyp/couriers");
    }

    @Test
    void suggestionSection2() {
        step.suggestionSectionScroll()
                .suggestionSection2Text("Serve more people as a restaurant partner")
                .suggestionSection2ApplyNow("Apply now")
                .suggestionSection2ApplyLink("/en/merchants")
                .status200Link("https://wolt.com/en/merchants");
    }

    @Test
    void suggestionSection3() {
        step.suggestionSectionScroll()




        $(".CardRow__Title-sc-36zoul-1").scrollTo();
        $(".Card__Root-sc-1wsaipe-0", 2).shouldHave(Condition.text("Enter a new chapter and find a job at Wolt"));
        $(".Card-module__img___NhWat", 2).shouldHave(Condition.attribute("style"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 2).shouldHave(Condition.text("Apply now"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 2).shouldHave(Condition.href("https://careers.wolt.com"));
        $(".LinkButton__StyledAnchor-sc-7867te-0", 2).click();
        webdriver().shouldHave(url("https://careers.wolt.com/en"));
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





