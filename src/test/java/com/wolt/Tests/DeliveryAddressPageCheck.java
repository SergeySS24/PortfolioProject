package com.wolt.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryAddressPageCheck extends Base2 {

    @Test
    void topSearchBarCheck() {
        $(".SearchInput__Input-sc-1web0kr-2")
                .shouldHave(Condition.attribute("placeholder", "Search in Wolt..."));
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
    void mainDiscoveryElements(){

        $$(".RenderDiscoveryFormat__SectionWrapper-sc-o3nb6j-1").filterBy(Condition.text("Pizza Hut")).shouldHave(CollectionCondition.texts("Pizza Hut"));
        //$(byXpath("//*[@id=\"mainContent\"]/div[3]/div/div/div[1]/div/div/div/ul/li[1]/div")).shouldBe(Condition.hidden);
       // Object banner = new By.ByXPath("//*[@id=\"mainContent\"]/div[3]/div/div/div[1]/div/div/div/ul/li[5]");
        //*[@id="mainContent"]/div[3]/div/div/div[1]/div/div/div/ul/li[5]
    }

    @Disabled
    @Test
    void bigGameOffers() {
        $(".Header-module__headerContainer___gNVva").shouldHave(Condition.text("Big game offers ⚽"));
    }


    @Test
    void categories() {
        $(".Header__Heading-sc-1qa68ul-0").shouldHave(Condition.text("Categories"));
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
        $$(".Carousel__ItemContainer-sc-tpksmz-2").filterBy(Condition.text("Cafe")).shouldHave(CollectionCondition.texts("Cafe"));
        $$(".Carousel__ItemContainer-sc-tpksmz-2").filterBy(Condition.text("138 places")).shouldHave(CollectionCondition.texts("138 places"));
    }


    @Test
    void storesGroceryCheck() {
        //$$(".LinkWithLocale__StyledLink-sc-1xr70lo-0").find(Condition.href("/en/discovery/category/grocery"))
               // .shouldHave(Condition.href("/en/discovery/category/grocery"));
        $$(".Carousel__ItemContainer-sc-tpksmz-2").filterBy(Condition.text("Grocery")).shouldHave(CollectionCondition.texts("Grocery"));
       // $$(".Carousel__ItemContainer-sc-tpksmz-2").filterBy(Condition.text("32 places")).shouldHave(CollectionCondition.texts("32 places"));
    }
}
