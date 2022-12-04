package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base3;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RestaurantPageCheck extends Base3 {


    @Test
    void restaurantDeliveryTimeCheck() {
        $(".ContentButton-module__text___vgef8").shouldHave(Condition.text("The average delivery time is"));
        $(".ContentButton-module__text___vgef8").shouldHave(Condition.text("min"));
    }


    @Test
    void restaurantOpenTimeCheck() {
        $(".OpeningHoursSnackbar__VenueInformationButton-sc-15xvzc-0").shouldHave(Condition.text("Open today:"));
    }


    @Test
    void restaurantMainInformationCheck() {
        $(".OpeningHoursSnackbar__StyledCaret-sc-15xvzc-2").click();
        $(".leaflet-interactive").shouldHave(Condition.attribute("d",
                "M116 182L118 156L143 156L170 141L193 119L298 78L341 78L396 98L409 98L422 " +
                        "123L428 144L414 144L367 157L229 326L136 194z")); // map check
        $(".VenueBaseInformation__VenueLargeHeader-sc-13ahrno-2").shouldHave(Condition.text("The Smuggers")); //Restaurant name check
        $(".VenueBaseInformation__VenueDescription-sc-13ahrno-6").shouldHave(Condition.text("It brings the smug in you!"));
        $(".VenueLocationInformation__VenueSmallHeader-sc-qwdnoj-1").shouldHave(Condition.text("Address"));
        $(".VenueLocationInformation__VenueAddress-sc-qwdnoj-2").shouldHave(Condition.text("Platonos 7"));
        $(".VenueOpeningInformation__VenueSmallHeader-sc-9288mn-1").shouldHave(Condition.text("Opening times"));
        $$(".ModalCardPage__ScrollContainer-sc-79y6nv-4").findBy(Condition.text("Monday-Sunday"))
                .shouldHave(Condition.text("Monday-Sunday"));
    }


    @Test
    void restaurantBannerCheck() {
        $(".VenueHeroBanner__TitleSpan-sc-3gkm9v-2").shouldHave(Condition.text("The Smuggers"));
    }



}
