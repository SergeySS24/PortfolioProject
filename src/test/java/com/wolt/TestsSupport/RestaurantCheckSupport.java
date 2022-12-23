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
    public RestaurantCheckSupport itemCheck(String item) {
        $$(".Categories-module__root___qegos").find(Condition.text("WRAPS")).shouldHave(Condition.text(item));
        return this;
    }








    }




















