package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base2;
import com.wolt.TestsSupport.DeliveryAddressPageSupport;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DeliveryAddressPageCheck extends Base2 {

    DeliveryAddressPageSupport step = new DeliveryAddressPageSupport();

    @Test
    void topSearchBarCheck() {
        step.searchBarPlaceholder("Search in Wolt...");
    }


    @Test
    void topSearchBarSearch() {
        step.searchBarSetValue("The Smuggers")
                .searchBarResult("The Smuggers")
                .searchBarResult("It brings the smug in you!")
                .searchBarItemJpg()
                .status200Check("https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/e52f6fa4-5b78-11ed-a739-8e9729307532_image_6483441.jpg");
    }

    @Test
    void subNavigationDiscoveryElementCheck() {
        step.subNavigationSection("Discovery")
                .elementLink("/en/discovery")
                .status200Check("https://wolt.com/en/discovery")
                .elementBlueFilling("/en/discovery");
    }

    @Test
    void subNavigationRestaurantsElementCheck() {
        step.subNavigationSection("Restaurants")
                .elementLink("/en/discovery/restaurants")
                .status200Check("https://wolt.com/en/discovery")
                .elementWithoutFilling("/en/discovery/restaurants");
    }

    @Test
    void subNavigationStoresElementCheck() {
        step.subNavigationSection("Stores")
                .elementLink("/en/discovery/stores")
                .status200Check("https://wolt.com/en/discovery/stores")
                .elementWithoutFilling("/en/discovery/stores");
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
                .sendingGiftLink("/en/cyp/limassol/venue/wolt-giftcard")
                .status200Check("https://wolt.com/en/cyp/limassol/venue/wolt-giftcard");
    }


    @Test
    void categoryCafeTileCheck() {
        step.categoryTile("/en/discovery/category/cafe")
                .status200Check("https://wolt.com/en/discovery/category/cafe")
                .categoryTileHeader("Cafe");
    }


    @Test
    void storesGroceryCheck() {
        step.categoryTile("/en/discovery/category/grocery")
                .status200Check("https://wolt.com/en/discovery/category/grocery")
                .categoryTileHeader("Grocery");
    }


    @Test
    void supermarketsKioskysCheck() {
        step.kioskysSupermarketLogo()
                .status200Check("https://imageproxy.wolt.com/wolt-frontpage-images/cities/helsinki/sections/" +
                        "1ce76eac-fe99-11ec-9cce-4a7e419f12b8_nvfhjfg___copy.jpg")
                        .categoryTileHeader("Kiosky's");
    }


    @Test
    void tileEnlargeCheck()  {
        step.categoryTileScroll("/en/discovery/category/cafe")
                .categoryTileHeaderHover("Cafe")
                .categoryTileEnlarge();
    }



}
