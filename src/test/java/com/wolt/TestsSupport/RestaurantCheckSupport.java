package com.wolt.TestsSupport;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.restassured.RestAssured.given;

public class RestaurantCheckSupport {

    @Step ("Restaurant opening hours")
    public RestaurantCheckSupport openingHours(String hours) {
        $(".OpeningHoursSnackbar__VenueInformationButton-sc-15xvzc-0").shouldHave(Condition.text(hours));
        return this;
    }

    @Step ("Restaurant information card click")
    public RestaurantCheckSupport informationCardClick() {
        $(".OpeningHoursSnackbar__StyledCaret-sc-15xvzc-2").shouldBe(Condition.visible);
        $(".OpeningHoursSnackbar__StyledCaret-sc-15xvzc-2").click();
        return this;
    }

    @Step ("Restaurant information map check")
    public RestaurantCheckSupport informationCardMapCheck() {
        $(".leaflet-interactive").shouldHave(Condition.attribute("d",
                "M116 182L118 153L121 145L169 136L193 119L298 78L341 78L396 98L409 98L422 123L428 144L414 144L367 157L229 326L136 194z"));
        return this;
    }

    @Step ("Restaurant information card restaurant header and description")
    public RestaurantCheckSupport informationCardRestInfo(String heading, String description) {
        $(".VenueBaseInformation__VenueLargeHeader-sc-13ahrno-2").shouldHave(Condition.text(heading));
        $(".VenueBaseInformation__VenueDescription-sc-13ahrno-6").shouldHave(Condition.text(description));
        return this;
    }

    @Step ("Restaurant information card containing information about address")
    public RestaurantCheckSupport informationCardAddress(String header, String address, String map) {
        $(".VenueLocationInformation__VenueSmallHeader-sc-qwdnoj-1").shouldHave(Condition.text(header));
        $(".VenueLocationInformation__VenueAddress-sc-qwdnoj-2").shouldHave(Condition.text(address));
        $$(".VenueLocationInformation__Root-sc-qwdnoj-0").find(Condition.text(map))
                .shouldHave(Condition.text(map));
        return this;
    }

    @Step ("Restaurant information card restaurant opening times information")
    public RestaurantCheckSupport informationCardOpeningTimes(String days, String hours) {
        $$(".VenueOpeningInformation__Root-sc-9288mn-0").find(Condition.text("Opening times"))
                .shouldHave(Condition.text("Opening times"));
        $$(".VenueOpeningInformation__Root-sc-9288mn-0").find(Condition.text(days))
                .shouldHave(Condition.text(days));
        $$(".VenueOpeningInformation__Root-sc-9288mn-0").find(Condition.text(hours))
                .shouldHave(Condition.text(hours));
        return this;
    }

    @Step ("Restaurant main page name and description")
    public RestaurantCheckSupport restaurantName(String name, String description) {
        $(".VenueHeroBanner__TitleSpan-sc-3gkm9v-2").shouldHave(Condition.text(name));
        $(".VenueHeroBanner__Description-sc-3gkm9v-4").shouldHave(Condition.text(description));
        return this;
    }

    @Step ("Price for minimum order")
    public RestaurantCheckSupport minimumOrderCheck(String price) {
        $$(".Tag__Root-sc-1pndqvl-0").find(Condition.text(price)).shouldHave(Condition.text(price));
        return this;
    }

    @Step ("Verifying background image")
    public RestaurantCheckSupport backgroundImage() {
        $$(".VenueBackground-module__image___o1lTk").find(Condition.attribute("src",
                        "https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/ea63213c-5b78-11ed-ba7c-2a44cd244fb3_image_6483441.jpg"))
                .shouldHave(Condition.attribute("src",
                        "https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/ea63213c-5b78-11ed-ba7c-2a44cd244fb3_image_6483441.jpg"));
        return this;
    }

    @Step ("Average restaurant rating")
    public RestaurantCheckSupport averageScore(String score) {
        $(".RatingsButton-module__score___fTqMn").shouldHave(Condition.text(score));
        return this;
    }

    @Step ("Presence of the favorite button")
    public RestaurantCheckSupport favoriteButton(String text) {
        $(".FavoriteButton-module__button___WF8rF").shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Search field has the placeholder")
    public RestaurantCheckSupport searchFieldPlaceholder(String placeholder) {
            $(".SearchField-module__input___fS6Zk").shouldHave(Condition.attribute("placeholder", placeholder));
        return this;
    }

    @Step ("Verifying the top item category")
    public RestaurantCheckSupport topCategory(String special) {
        $(".Categories-module__listItem___RjQkC").shouldHave(Condition.text(special));
        return this;
    }

    @Step ("Checking 'WRAPS' item in the list of items")
    public RestaurantCheckSupport listItemCheck(String item) {
        $$(".Categories-module__root___qegos").find(Condition.text("WRAPS")).shouldHave(Condition.text(item));
        return this;
    }

    @Step ("Open 'Dessert' category and check that opened 'Dessert' category")
    public RestaurantCheckSupport openCategory(String item) {
        $$(".Categories-module__categoryLink___WM_5v").find(Condition.text(item)).shouldHave(Condition.text(item)).click();
        $$(".MenuCategoryHeader__Heading-sc-1enduc0-0").find(Condition.text(item)).shouldHave(Condition.text(item)).shouldBe(Condition.visible);
        return this;
    }

    @Step ("Verifying item in the selected section")
    public RestaurantCheckSupport openedItemCheck(String item, String price) {
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text(item))
                .shouldHave(Condition.text(item)).shouldHave(Condition.text(price)).shouldBe(Condition.visible);
        return this;
    }

    @Step ("Selected item has href")
    public RestaurantCheckSupport dessertItemCardHref(String href) {
        $$(".MenuItem-module__toggle___iTf9H")
                .find(Condition.href(href)).shouldHave(Condition.href(href));
        return this;
    }

    @Step ("Open selected item into a separate card")
    public RestaurantCheckSupport openItemCard(String item, String price) {
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text(item))
                .shouldHave(Condition.text(item)).shouldHave(Condition.text(price)).click();
        return this;
    }

    @Step ("Check contents of the selected item card")
    public RestaurantCheckSupport openedDessertItemCardContents(String item, String price) {
        $(".ProductViewScreen__PaddedItem-sc-1pnst4x-1").shouldHave(Condition.text(item));
        $(".UnitAndPriceInfo__OriginalPrice-sc-1t66qe7-7").shouldHave(Condition.text(price));
        return this;
    }

    @Step ("Default value of the selected items")
    public RestaurantCheckSupport defaultCounterValueAtItemCard(String value) {
        $(".ModalNavigationButton__Content-sc-1x1lz0u-1").shouldHave(Condition.text("Product info"));
        $$(".Stepper__VisibleInput-sc-ho8tch-1").find(Condition.text("1")).shouldHave(Condition.text(value));
        return this;
    }

    @Step ("Submit button for the opened Item Card")
    public RestaurantCheckSupport submitButtonItemCard(String value) {
        $$(".ProductViewFooter__SubmitButtonContent-sc-34t03j-5").find(Condition.text("Add to order")).shouldHave(Condition.text("Add to order"));
        $$(".ProductViewFooter__Price-sc-34t03j-6").find(Condition.text("€4.00")).shouldHave(Condition.text(value));
        return this;
    }

    @Step ("Contents of the product info")
    public RestaurantCheckSupport productInfoContents(String item) {
        $(".ModalNavigationButton__Content-sc-1x1lz0u-1").shouldHave(Condition.text("Product info")).click();
        $$(".Modal__Container-sc-mw6f31-2").find(Condition.text("Product info")).shouldHave(Condition.text("Product info"));
        $$(".Modal__Container-sc-mw6f31-2").find(Condition.text(item)).shouldHave(Condition.text(item));
        return this;
    }

    @Step ("Verifying restaurant information")
    public RestaurantCheckSupport restaurantInformationSection(String address, String postcode) {
        $$(".VenueSideInfo__Root-sc-1bpnd7a-0").find(Condition.text("Restaurant information"))
                .shouldHave(Condition.text("Restaurant information"));
        $$(".VenueSideInfo__SectionTitle-sc-1bpnd7a-3").find(Condition.text("Address"))
                .shouldHave(Condition.text("Address"));
        $$(".VenueSideInfo__Block-sc-1bpnd7a-1").find(Condition.text(address)).shouldHave(Condition.text(address));
        $$(".VenueSideInfo__Block-sc-1bpnd7a-1").find(Condition.text(postcode)).shouldHave(Condition.text(postcode));
        $$(".VenueSideInfo__SectionTitle-sc-1bpnd7a-3").find(Condition.text("Opening times"))
                .shouldHave(Condition.text("Opening times"));
        return this;
    }

    @Step ("Set value to the search field")
    public RestaurantCheckSupport searchFieldSetValue(String value) {
        $(".SearchField-module__input___fS6Zk").setValue(value);
        return this;
    }

    @Step ("Check found item section")
    public RestaurantCheckSupport checkFoundItemSection(String item) {
        $$(".Venue-module__menu___E3Uyw").find(Condition.text(item)).shouldHave(Condition.text(item));
        $$(".Venue-module__categories___Lp8Or")
                .find(Condition.text(item)).shouldHave(Condition.text(item));
        return this;
    }

    @Step ("Check found item card")
    public RestaurantCheckSupport checkFoundItemCard(String item) {
        $$(".MenuItem-module__itemContainer____1T8k").find(Condition.text(item)).shouldHave(Condition.text(item));
        $(".MenuItem-module__toggle___iTf9H").shouldHave(Condition.href("/en/cyp/limassol/restaurant/the-smuggers/pineapple-dreams-itemid-635f6b8bc76974bc0607abef"));
        return this;
    }
}




















