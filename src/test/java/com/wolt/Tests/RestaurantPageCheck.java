package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import com.wolt.TestsSupport.Base3;
import com.wolt.TestsSupport.OtherSupport;
import com.wolt.TestsSupport.RestaurantCheckSupport;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class RestaurantPageCheck extends Base3 {

    RestaurantCheckSupport step = new RestaurantCheckSupport();
    OtherSupport api = new OtherSupport();

    @Test
    void restaurantOpenTimeCheck() {
        step.openingHours("Open today:");
    }

    @Test
    void restaurantMainInformationCheck() {
        step.informationCardClick()
                .informationCardMapCheck()
                .informationCardRestInfo("The Smuggers", "It brings the smug in you!")
                .informationCardAddress("Address", "Platonos 7", "See map");
        api.status200Check("https://www.google.com/maps?q=34.685806855152364,33.04388570674683");
        step.informationCardOpeningTimes("Opening times", "Monday-Sunday");
    }

    @Test
    void restaurantBannerCheck() {
        step.restaurantName("The Smuggers", "It brings the smug in you!");
    }

    @Test
    void minOrderCheck() {
        step.minimumOrderCheck( "€6.00");
    }

    @Test
    void backgroundImageCheck() {
        step.backgroundImage();
    }

    @Test
    void ratingScoreCheck() {
        step.averageScore("9.2");
    }

    @Test
    void favoriteButtonCheck() {
        step.favoriteButton("Favorite");
    }

    @Test
    void searchFieldCheck() {
        step.searchFieldPlaceholder("Search");
    }

    @Test
    void topCategoryCheck() {
        step.topCategory("CHRISTMAS SPECIAL");
    }

    @Test
    void categoryCheck() {
        step.itemCheck("WRAPS");

        //$$(".Categories-module__root___qegos").find(Condition.text("WRAPS")).shouldHave(Condition.text("WRAPS"));
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
