package com.wolt.Tests;

import com.codeborne.selenide.Selenide;
import com.wolt.TestsSupport.TestsBase.Base;
import com.wolt.TestsSupport.UnumSupport.Cities2;
import com.wolt.TestsSupport.TestsSupport.MainPageSupport;
import com.wolt.TestsSupport.TestsSupport.OtherSupport;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPageCheck extends Base {

    MainPageSupport step = new MainPageSupport();
    OtherSupport api = new OtherSupport();

    @Test
    void woltLogoClick() {
        step.logoClick();
                api.status200Check("https://wolt.com/en/discovery");
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
                .interactiveModuleBackground();
                api.status200Check("https://consumer-static-assets.wolt.com/frontpage-assets/front-cells.png");
    }

    @Test
    void suggestionSection1() {
        step.suggestionSectionScroll()
                .suggestionSectionHeading("Hungry for more than food?")
                .suggestionSection1Text("Get paid as a courier partner")
                .suggestionSection1ApplyNow("Apply now")
                .suggestionSection1ApplyLink("https://explore.wolt.com/en/cyp/couriers");
                api.status200Check("https://explore.wolt.com/en/cyp/couriers");
    }

    @Test
    void suggestionSection2() {
        step.suggestionSectionScroll()
                .suggestionSection2Text("Serve more people as a restaurant partner")
                .suggestionSection2ApplyNow("Apply now")
                .suggestionSection2ApplyLink("/en/merchants");
                api.status200Check("https://wolt.com/en/merchants");
    }

    @Test
    void suggestionSection3() {
        step.suggestionSectionScroll()
                .suggestionSection3Text("Enter a new chapter and find a job at Wolt")
                .suggestionSection3ApplyNow("Apply now")
                .suggestionSection3ApplyLink("https://careers.wolt.com");
                api.status200Check("https://careers.wolt.com/en");
    }

    @Test
    void footerAppStoreCheck() {
        step.footerScroll()
                .footerAppleStoreIcon()
                .footerAppleStoreIconTitle("Download the Wolt iOS app on the App Store");
    }


    @Test
    void footerGooglePlayCheck() {
        step.footerScroll()
                .footerGooglePlayIcon()
                .footerGooglePlayIconTitle("Download the Wolt Android app on Google Play");
    }


    //checking first footer column
    @ValueSource(strings = {
            "For couriers",
            "For restaurants",
            "For stores",
            "For companies",
            "Wolt Drive"
    })

    @ParameterizedTest(name = "checking first footer column for word {0}")
    void firstFooterColumnCheck(String testData) {
        step.footerScroll()
                .footerFirstColumnHeading("Let's do this together")
                .footerFirstColumContent(testData);
    }

    @Test
    void firstFooterColumnLinkCheck() {
        step.footerScroll()
                .forCountriesLinkCheck("https://explore.wolt.com/en/cyp/couriers")
                .forRestaurantsLinkCheck("/en/merchants")
                .forStoresLinkCheck("/en/retailers")
                .forCompaniesLinkCheck("/en/wolt-at-work")
                .woltDriveLinkCheck("/en/drive");
                api.status200Check("https://explore.wolt.com/en/cyp/couriers")
                .status200Check("https://wolt.com/en/retailers")
                .status200Check("https://wolt.com/en/wolt-at-work")
                .status200Check("https://wolt.com/en/drive");
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
        step.footerScroll()
                .footerSecondColumnHeading("Company")
                .footerSecondColumContent(testData);
    }


    //checking third footer column
    @ValueSource(strings = {
            "Support",
            "Media",
            "Contact"
    })

    @ParameterizedTest(name = "checking third footer column for word {0}")
    void thirdFooterColumnCheck(String testData) {
        step.footerScroll()
                .footerThirdColumnHeading("Useful links")
                .footerThirdColumContent(testData);
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
        step.footerScroll()
                .footerFourthColumnHeading("Follow us")
                .footerFourthColumContent(testData);
    }


    @Test
    void bottomBarOne() {
        step.footerScroll()
                .leftBottomBarElements("Cyprus", "English", "Accessibility");
    }


    @Test
    void bottomBarTwo() {
        step.footerScroll()
                .rightBottomBarElements("Accessibility Statement", "Terms and Conditions", "Privacy Policy");
    }

    @Test
    void bottomStamp() {
        step.footerScroll()
                .bottomStamp("©️ Wolt 2014–2022");
    }

    @AfterEach
    public void finish() {
        Selenide.closeWindow();
    }
}





