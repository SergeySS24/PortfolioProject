package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base2;
import com.wolt.TestsSupport.DeliveryAddressPageSupport;
import com.wolt.TestsSupport.MainPageSupport;
import com.wolt.TestsSupport.OtherSupport;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DeliveryAddressPageCheck extends Base2 {

    DeliveryAddressPageSupport step = new DeliveryAddressPageSupport();
    OtherSupport api = new OtherSupport();

    @Test
    void topSearchBarCheck() {
        step.searchBarPlaceholder("Search in Wolt...");
    }

    @Test
    void topSearchBarSearch() {
        step.searchBarSetValue("The Smuggers")
                .searchBarResult("The Smuggers")
                .searchBarResult("It brings the smug in you!")
                .searchBarItemJpg();
        api.status200Check("https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/e52f6fa4-5b78-11ed-a739-8e9729307532_image_6483441.jpg");
    }

    @Test
    void subNavigationDiscoveryElementCheck() {
        step.subNavigationSection("Discovery")
                .elementLink("/en/discovery");
                api.status200Check("https://wolt.com/en/discovery");
                step.elementBlueFilling("/en/discovery");
    }

    @Test
    void subNavigationRestaurantsElementCheck() {
        step.subNavigationSection("Restaurants")
                .elementLink("/en/discovery/restaurants");
                api.status200Check("https://wolt.com/en/discovery");
                step.elementWithoutFilling("/en/discovery/restaurants");
    }

    @Test
    void subNavigationStoresElementCheck() {
        step.subNavigationSection("Stores")
                .elementLink("/en/discovery/stores");
                api.status200Check("https://wolt.com/en/discovery/stores");
                step.elementWithoutFilling("/en/discovery/stores");
    }

    @Test //Warning: dynamic tile and may be removed
    void unlimitedFreeDeliveriesTileCheck() {
        step.unlimitedDeliveriesTile();
    }

    @Test
    void disablePreviousButtonCategoriesSection() {
        step.buttonElementDisabled();
    }

    @Test
    void nextButtonCheck() {
        step.buttonElementEnabled();
    }

    @Test
    void categoriesCheck() {
        step.sectionHeading("Categories");
    }

    @Test
    void supermarketsCheck() {
        step.sectionHeading("Supermarkets");
    }

    @Test
    void fastestDeliveryCheck() {
        step.sectionHeading("Fastest delivery");
    }

    @Test
    void popularRightNow() {
        step.sectionHeading("Popular right now");
    }


    @Test
    void topRatedCheck() {
        step.sectionHeading("Top-rated");
    }


    @Test
    void storesCheck() {
        step.sectionHeading("Stores");
    }


    @Test
    void newRestaurantsCheck() {
        step.sectionHeading("New restaurants on Wolt");
    }


    @Test
    void quickLinksCheck() {
        step.quickLinksHeading("Quick links")
                .sendingGift("Send a gift")
                .sendingGiftLink("/en/cyp/limassol/venue/wolt-giftcard");
                api.status200Check("https://wolt.com/en/cyp/limassol/venue/wolt-giftcard");
    }

    @Test
    void categoryCafeTileCheck() {
        step.categoryTile("/en/discovery/category/cafe");
                api.status200Check("https://wolt.com/en/discovery/category/cafe");
                step.categoryTileHeader("Cafe");
    }

    @Test
    void storesGroceryCheck() {
        step.categoryTile("/en/discovery/category/grocery");
                api.status200Check("https://wolt.com/en/discovery/category/grocery");
                step.categoryTileHeader("Grocery");
    }

    @Test
    void supermarketsKioskysCheck() {
        step.kioskysSupermarketLogo();
                api.status200Check("https://imageproxy.wolt.com/wolt-frontpage-images/cities/helsinki/sections/" +
                        "1ce76eac-fe99-11ec-9cce-4a7e419f12b8_nvfhjfg___copy.jpg");
                step.categoryTileHeader("Kiosky's");
    }

    @Test
    void tileEnlargeCheck()  {
        step.categoryTileScroll("/en/discovery/category/cafe")
                .categoryTileHeaderHover("Cafe")
                .categoryTileEnlarge();
    }



}
