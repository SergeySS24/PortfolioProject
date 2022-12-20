package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base3;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RestaurantPageCheck extends Base3 {


    @Test
    void restaurantOpenTimeCheck() {
        $(".OpeningHoursSnackbar__VenueInformationButton-sc-15xvzc-0").shouldHave(Condition.text("Open today:"));
    }


    @Test
    void restaurantMainInformationCheck() {
        $(".OpeningHoursSnackbar__StyledCaret-sc-15xvzc-2").shouldBe(Condition.visible);
        $(".OpeningHoursSnackbar__StyledCaret-sc-15xvzc-2").click();
        $(".leaflet-interactive").shouldHave(Condition.attribute("d",
                "M116 182L118 153L121 145L169 136L193 119L298 78L341 78L396 98L409 98L422 123L428 144L414 144L367 157L229 326L136 194z")); // map check
        $(".VenueBaseInformation__VenueLargeHeader-sc-13ahrno-2").shouldHave(Condition.text("The Smuggers")); //Restaurant name check
        $(".VenueBaseInformation__VenueDescription-sc-13ahrno-6").shouldHave(Condition.text("It brings the smug in you!"));
        $(".VenueLocationInformation__VenueSmallHeader-sc-qwdnoj-1").shouldHave(Condition.text("Address"));
        $(".VenueLocationInformation__VenueAddress-sc-qwdnoj-2").shouldHave(Condition.text("Platonos 7"));
        $(".VenueOpeningInformation__VenueSmallHeader-sc-9288mn-1").shouldHave(Condition.text("Opening times"));
        $$(".ModalCardPage__ScrollContainer-sc-79y6nv-4").findBy(Condition.text("Monday-Sunday"))
                .shouldHave(Condition.text("Monday-Sunday"));
        $$(".VenueLocationInformation__Root-sc-qwdnoj-0").find(Condition.text("See map"))
                .shouldHave(Condition.text("See map"));
        $$(".VenueOpeningInformation__Root-sc-9288mn-0").find(Condition.text("Opening times"))
                .shouldHave(Condition.text("Opening times"));
        $$(".VenueOpeningInformation__Root-sc-9288mn-0").find(Condition.text("Monday-Sunday"))
                .shouldHave(Condition.text("Monday-Sunday"));
        $$(".VenueOpeningInformation__Root-sc-9288mn-0").find(Condition.text("12.00–23.30"))
                .shouldHave(Condition.text("12.00–23.30"));
        $$(".CombinedHours__Day-sc-189qmtd-0").find(Condition.text("Monday-Sunday"))
                .shouldHave(Condition.text("Monday-Sunday"));
        $$(".CombinedHours__HoursItem-sc-189qmtd-3").find(Condition.text("12.00–23.30"))
                .shouldHave(Condition.text("12.00–23.30"));
    }


    @Test
    void restaurantBannerCheck() {
        $(".VenueHeroBanner__TitleSpan-sc-3gkm9v-2").shouldHave(Condition.text("The Smuggers"));
        $(".VenueHeroBanner__Description-sc-3gkm9v-4").shouldHave(Condition.text("It brings the smug in you!"));
    }


    @Test
    void deliveryPriceCheck() {
        $(".Tag__Root-sc-1pndqvl-0").shouldHave(Condition.text("Delivery: ")).shouldHave(Condition.text("€1.35"));
    }


    @Test
    void minOrderCheck() {
        $(".Tag__Root-sc-1pndqvl-0", 1).shouldHave(Condition.text("Min. order: ")).shouldHave(Condition.text("€6.00"));
    }


    @Test
    void backgroundImageCheck() {
        $$(".VenueBackground-module__image___o1lTk").find(Condition.attribute("src",
                "https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/ea63213c-5b78-11ed-ba7c-2a44cd244fb3_image_6483441.jpg"))
                .shouldHave(Condition.attribute("src",
                        "https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/ea63213c-5b78-11ed-ba7c-2a44cd244fb3_image_6483441.jpg"));
    }


    @Test
    void ratingScoreCheck() {
        $(".RatingsButton-module__score___fTqMn").shouldHave(Condition.text("9.2"));
    }


    @Test
    void favoriteButtonCheck() {
        $(".FavoriteButton-module__button___WF8rF").shouldHave(Condition.text("Favorite"));
    }


    @Test
    void searchFieldnCheck() {
        $(".SearchField-module__input___fS6Zk").shouldHave(Condition.attribute("placeholder", "Search"));
    }


    @Test
    void topCategoryCheck() {
    $(".Categories-module__listItem___RjQkC").shouldHave(Condition.text("CHRISTMAS SPECIAL"));
    }


    @Test
    void categoryCheck() {
        $$(".Categories-module__root___qegos").find(Condition.text("WRAPS")).shouldHave(Condition.text("WRAPS"));
    }


    @Test
    void openDessertsSection() {
        $$(".Categories-module__categoryLink___WM_5v").find(Condition.text("DESSERTS")).shouldHave(Condition.text("DESSERTS")).click();
        $$(".MenuCategoryHeader__Heading-sc-1enduc0-0").find(Condition.text("DESSERTS")).shouldHave(Condition.text("DESSERTS")).shouldBe(Condition.visible);
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text("Milk Chocolate Cookie"))
                .shouldHave(Condition.text("Milk Chocolate Cookie")).shouldHave(Condition.text("€4.00")).shouldBe(Condition.visible);
        $$(".MenuItem-module__toggle___iTf9H")
                .find(Condition.href("/en/cyp/limassol/restaurant/the-smuggers/milk-chocolate-cookie-itemid-638f18a4512bb58766b10e83"))
                .shouldHave(Condition.href("/en/cyp/limassol/restaurant/the-smuggers/milk-chocolate-cookie-itemid-638f18a4512bb58766b10e83"));
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text("Pistachio Cookie"))
                .shouldHave(Condition.text("Pistachio Cookie")).shouldHave(Condition.text("€4.50")).shouldBe(Condition.visible);
        $$(".MenuItem-module__toggle___iTf9H")
                .find(Condition.href("/en/cyp/limassol/restaurant/the-smuggers/pistachio-cookie-itemid-638f18b4d454e9f4bdbc7d94"))
                .shouldHave(Condition.href("/en/cyp/limassol/restaurant/the-smuggers/pistachio-cookie-itemid-638f18b4d454e9f4bdbc7d94"));
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text("Halva Brownie"))
                .shouldHave(Condition.text("Halva Brownie")).shouldHave(Condition.text("€4.50")).shouldBe(Condition.visible);
        $$(".MenuItem-module__toggle___iTf9H")
                .find(Condition.href("/en/cyp/limassol/restaurant/the-smuggers/halva-brownie-itemid-638f18c0d786bf1cf72f49c7"))
                .shouldHave(Condition.href("/en/cyp/limassol/restaurant/the-smuggers/halva-brownie-itemid-638f18c0d786bf1cf72f49c7"));
    }


    @Test
    void productOpenCheck() {
        $$(".Categories-module__categoryLink___WM_5v").find(Condition.text("DESSERTS")).shouldHave(Condition.text("DESSERTS")).click();
        $$(".MenuCategoryHeader__Heading-sc-1enduc0-0").find(Condition.text("DESSERTS")).shouldHave(Condition.text("DESSERTS")).shouldBe(Condition.visible);
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text("Milk Chocolate Cookie"))
                .shouldHave(Condition.text("Milk Chocolate Cookie")).shouldHave(Condition.text("€4.00")).click();
        $(".ProductViewScreen__PaddedItem-sc-1pnst4x-1").shouldHave(Condition.text("Milk Chocolate Cookie"));
        $(".UnitAndPriceInfo__OriginalPrice-sc-1t66qe7-7").shouldHave(Condition.text("€4.00"));
        $(".ModalNavigationButton__Content-sc-1x1lz0u-1").shouldHave(Condition.text("Product info"));
        $$(".Stepper__VisibleInput-sc-ho8tch-1").find(Condition.text("1")).shouldHave(Condition.text("1"));
        $$(".ProductViewFooter__SubmitButtonContent-sc-34t03j-5").find(Condition.text("Add to order")).shouldHave(Condition.text("Add to order"));
        $$(".ProductViewFooter__Price-sc-34t03j-6").find(Condition.text("€4.00")).shouldHave(Condition.text("€4.00"));
        $(".ModalNavigationButton__Content-sc-1x1lz0u-1").shouldHave(Condition.text("Product info")).click();
        $$(".Modal__Container-sc-mw6f31-2").find(Condition.text("Product info")).shouldHave(Condition.text("Product info"));
        $$(".Modal__Container-sc-mw6f31-2").find(Condition.text("Milk Chocolate Cookie")).shouldHave(Condition.text("Milk Chocolate Cookie"));
    }


    @Test
    void restaurantInformation() {
        $$(".VenueSideInfo__Root-sc-1bpnd7a-0").find(Condition.text("Restaurant information"))
                .shouldHave(Condition.text("Restaurant information"));
        $$(".VenueSideInfo__SectionTitle-sc-1bpnd7a-3").find(Condition.text("Address"))
                .shouldHave(Condition.text("Address"));
        $$(".VenueSideInfo__SectionTitle-sc-1bpnd7a-3").find(Condition.text("Opening times"))
                .shouldHave(Condition.text("Opening times"));
    }


    @Test
    void searchItem() {
        $(".SearchField-module__input___fS6Zk").setValue("Pineapple Dreams");
        $$(".Venue-module__menu___E3Uyw").find(Condition.text("CHICKEN BURGERS")).shouldHave(Condition.text("CHICKEN BURGERS"));
        $$(".Venue-module__categories___Lp8Or")
                .find(Condition.text("CHICKEN BURGERS")).shouldHave(Condition.text("CHICKEN BURGERS"));
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text("Pineapple Dreams")).shouldHave(Condition.text("Pineapple Dreams"));
        $(".MenuItem-module__toggle___iTf9H").shouldHave(Condition.href("/en/cyp/limassol/restaurant/the-smuggers/pineapple-dreams-itemid-635f6b8bc76974bc0607abef"));
    }
}
