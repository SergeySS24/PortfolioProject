package com.wolt.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class DeliveryAddressPageCheck extends Base2 {

    @Test
    void topSearchBarCheck() {
        $(".SearchInput__Input-sc-1web0kr-2")
                .shouldHave(Condition.attribute("placeholder", "Search in Wolt..."));
    }


    @Test
    void topSearchBarSearch() {
        $(".SearchInput__Input-sc-1web0kr-2").setValue("The Smuggers");
        $(".SearchResultItem__Info-sc-1paxeg7-3").shouldHave(Condition.text("The Smuggers"));
        $(".SearchResultItem__Info-sc-1paxeg7-3").shouldHave(Condition.text("It brings the smug in you!"));
        $$(".ImageWithBlurHashTransition__StyledImage-sc-58sbex-1").findBy(Condition.attribute("src",
                "https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/e52f6fa4-5b78-11ed-a739-8e9729307532_image_6483441.jpg"))
                .shouldHave(Condition.attribute("src",
                        "https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/e52f6fa4-5b78-11ed-a739-8e9729307532_image_6483441.jpg"));
    }


    @Test
    void subNavigationDiscoveryElementCheck() {
        $(".DesktopDiscoveryTabLink__Label-sc-1qoyay1-1").shouldHave(Condition.text("Discovery"));
        $(".DesktopDiscoveryTabLink__StyledNavLink-sc-1qoyay1-0").shouldHave(Condition.href("/en/discovery"));
        $(".iMVcLF").shouldHave(Condition.visible); //Discovery option is selected and filled by blue color
    }


    @Test
    void subNavigationRestaurantsElementCheck() {
        $(".DesktopDiscoveryTabLink__Label-sc-1qoyay1-1", 1).shouldHave(Condition.text("Restaurants"));
        $(".DesktopDiscoveryTabLink__StyledNavLink-sc-1qoyay1-0", 1).shouldHave(Condition.href("/en/discovery/restaurants"));
        $(".iTHVni").shouldHave(Condition.visible); //Restaurants option is not selected and not filled by blue color
    }


    @Test
    void subNavigationStoresElementCheck() {
        $(".DesktopDiscoveryTabLink__Label-sc-1qoyay1-1", 2).shouldHave(Condition.text("Stores"));
        $(".DesktopDiscoveryTabLink__StyledNavLink-sc-1qoyay1-0", 2).shouldHave(Condition.href("/en/discovery/stores"));
        $(".iTHVni").shouldHave(Condition.visible); //Stores option is not selected and not filled by blue color
    }


    @Test
    void unlimitedFreeDekiveriesTileCheck() {
        $$(".ImageWithBlurHashTransition__StyledImage-sc-58sbex-1").findBy(Condition.attribute("src",
                        "https://imageproxy.wolt.com/wolt-frontpage-images/content_editor/banners/images/3ea4ab24-74bc-11ed-a0b9-5adf0be8436e_7955f2b0_f012_489d_8765_e8f3013bf7f4.png"))
                .shouldHave(Condition.attribute("src", "https://imageproxy.wolt.com/wolt-frontpage-images/content_editor/banners/images/3ea4ab24-74bc-11ed-a0b9-5adf0be8436e_7955f2b0_f012_489d_8765_e8f3013bf7f4.png"));
    }


    @Disabled
    @Test
    void pizzaHutLargeTileCheck(){
        $$(".BlurHashVideo__StyledVideo-sc-t3c8ra-3").findBy(Condition.attribute("poster",
                        "https://discovery-cdn.wolt.com/content_editor/banners/images/5572323c-6cc8-11ed-a91b-ce4cdf8d8e3b_61c00f4d_88d1_4a75_8652_794d502a3ebc.png"))
                .shouldHave(Condition.attribute("poster", "https://discovery-cdn.wolt.com/content_editor/banners/images/5572323c-6cc8-11ed-a91b-ce4cdf8d8e3b_61c00f4d_88d1_4a75_8652_794d502a3ebc.png"));
    }



    @Test
    void disablePreviousButtonCheck() {
        $$(".Header-module__prevNextButton___iuJ0q").findBy(Condition.attribute("disabled"))
                .shouldHave(Condition.attribute("disabled"));
    }


    @Test
    void nextButtonCheck() {
        $$(".Header-module__prevNextButton___iuJ0q").findBy(Condition.attribute("aria-label", "Next"))
                .shouldHave(Condition.attribute("aria-label", "Next")).shouldNotHave(Condition.attribute("disabled"));
    }


    @Disabled
    @Test
    void bigGameOffers() {
        $(".Header-module__headerContainer___gNVva").shouldHave(Condition.text("Big game offers ⚽"));
    }


    @Test
    void categories() {
        $$(".Header__Heading-sc-1qa68ul-0").findBy(Condition.text("Categories")).shouldHave(Condition.text("Categories"));
    }


    @Test
    void fastestDelivery() {
        $$(".Header__Heading-sc-1qa68ul-0").filterBy(Condition.text("Fastest delivery"))
                .shouldHave(CollectionCondition.texts("Fastest delivery"));
    }


    @Test
    void supermarkets() {
        $$(".Header__Heading-sc-1qa68ul-0").filterBy(Condition.text("Supermarkets"))
                .shouldHave(CollectionCondition.texts("Supermarkets"));
    }


    @Test
    void popularRightNow() {
        $$(".Header__Heading-sc-1qa68ul-0").filterBy(Condition.text("Popular right now"))
                .shouldHave(CollectionCondition.texts("Popular right now"));
    }


    @Test
    void topRated() {
        $$(".Header__Heading-sc-1qa68ul-0").filterBy(Condition.text("Top-rated"))
                .shouldHave(CollectionCondition.texts("Top-rated"));
    }


    @Test
    void stores() {
        $$(".Header__Heading-sc-1qa68ul-0").filterBy(Condition.text("Stores"))
                .shouldHave(CollectionCondition.texts("Stores"));
    }


    @Test
    void newRestaurants() {
        //$(".Header__Heading-sc-1qa68ul-0", 4).scrollTo();
        $$(".Header__Heading-sc-1qa68ul-0").filterBy(Condition.text("New restaurants on Wolt"))
                .shouldHave(CollectionCondition.texts("New restaurants on Wolt"));
    }


    @Test
    void freeDelivery() {
        //$(".Header__Heading-sc-1qa68ul-0", 4).scrollTo();
        $$(".Header__Heading-sc-1qa68ul-0").filterBy(Condition.text("Free delivery"))
                .shouldHave(CollectionCondition.texts("Free delivery"));
    }


    @Test
    void quickLinks() {
        $(".QuickLinks__ListTitle-sc-jkimc8-0").shouldHave(Condition.text("Quick links"));
        $(".QuickLinks-module__itemWrapper____Ne1r").$(".DiscoveryLink-module__link___bg0bC")
                .shouldHave(Condition.href("/en/cyp/limassol/venue/wolt-giftcard"));
    }


    @Test
    void categoryCafeCheck() {
        $$(".LinkWithLocale__StyledLink-sc-1xr70lo-0").find(Condition.href("/en/discovery/category/cafe"))
                .shouldHave(Condition.href("/en/discovery/category/cafe"));
        $$(".CategoryCardBody__Header-sc-1quwqfy-2").filterBy(Condition.text("Cafe")).shouldHave(CollectionCondition.texts("Cafe"));
        $$(".CategoryCardBody__Description-sc-1quwqfy-3").filterBy(Condition.text("141 places")).shouldHave(CollectionCondition.texts("141 places"));
    }


    @Test
    void storesGroceryCheck() {
        $$(".LinkWithLocale__StyledLink-sc-1xr70lo-0").find(Condition.href("/en/discovery/category/grocery"))
                .shouldHave(Condition.href("/en/discovery/category/grocery"));
        $$(".CategoryCardBody__Header-sc-1quwqfy-2").filterBy(Condition.text("Grocery")).shouldHave(CollectionCondition.texts("Grocery"));
        $$(".CategoryCardBody__Description-sc-1quwqfy-3").filterBy(Condition.text("33 places")).shouldHave(CollectionCondition.texts("33 places"));
    }


    @Test
    void supermarketsKioskysCheck() {
        $$(".ImageWithBlurHashTransition__StyledImage-sc-58sbex-1").findBy(Condition.attribute("src",
                "https://imageproxy.wolt.com/wolt-frontpage-images/cities/helsinki/sections/1ce76eac-fe99-11ec-9cce-4a7e419f12b8_nvfhjfg___copy.jpg"))
                        .shouldHave(Condition.attribute("src", "https://imageproxy.wolt.com/wolt-frontpage-images/cities/helsinki/sections/1ce76eac-fe99-11ec-9cce-4a7e419f12b8_nvfhjfg___copy.jpg"));
        $$(".CategoryCardBody__Header-sc-1quwqfy-2").filterBy(Condition.text("Kiosky's"))
                 .shouldHave(CollectionCondition.texts("Kiosky's"));
    }


    @Test
    void tileEnlargeCheck()  {
        $$(".LinkWithLocale__StyledLink-sc-1xr70lo-0").find(Condition.href("/en/discovery/category/cafe"))
                .shouldHave(Condition.href("/en/discovery/category/cafe")).scrollTo();
        $$(".CategoryCardBody__Header-sc-1quwqfy-2").find(Condition.text("Cafe")).hover();
        $(".iTVZbW").shouldBe(Condition.visible);
    }



}
