package com.wolt.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base2;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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




        //$(".HeroCarouselV2__Root-sc-bwwkga-0").$(".HeroCarouselV2__ListItem-sc-bwwkga-1",7)
               // .shouldHave(Condition.attribute("src", "https://imageproxy.wolt.com/" +
                      //  "wolt-frontpage-images/cities/helsinki/sections/da567e04-fef0-11ec-88d7-56875d0240fc_wolt_at_work_02.png"));
    }
}
