package com.wolt.TestsSupport;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.restassured.RestAssured.given;

public class DeliveryAddressPageSupport {

    @Step ("Seach bar has placeholder text")
    public DeliveryAddressPageSupport searchBarPlaceholder(String placeholder) {
        $(".SearchInput__Input-sc-1web0kr-2")
                .shouldHave(Condition.attribute("placeholder", placeholder));
        return this;
    }

    @Step ("Set value to the search bar")
    public DeliveryAddressPageSupport searchBarSetValue(String value) {
        $(".SearchInput__Input-sc-1web0kr-2").setValue(value);
        return this;
    }

    @Step ("Displaying search results")
    public DeliveryAddressPageSupport searchBarResult(String result) {
        $(".SearchResultItem__Info-sc-1paxeg7-3").shouldHave(Condition.text(result));
        return this;
    }

    @Step ("Searched item has jpg")
    public DeliveryAddressPageSupport searchBarItemJpg() {
        $$(".ImageWithBlurHashTransition__StyledImage-sc-58sbex-1").findBy(Condition.attribute("src",
                        "https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/e52f6fa4-5b78-11ed-a739-8e9729307532_image_6483441.jpg"))
                .shouldHave(Condition.attribute("src",
                        "https://imageproxy.wolt.com/venue/61dd470f2affdb8333e7278d/e52f6fa4-5b78-11ed-a739-8e9729307532_image_6483441.jpg"));
        return this;
    }

    @Step ("SubNavigation section has the following elements")
    public DeliveryAddressPageSupport subNavigationSection(String text) {
        Selenide.refresh();
        $$(".DesktopDiscoveryTabLink__Label-sc-1qoyay1-1").find(Condition.text(text)).shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Element from SubNavigation section contains link")
    public DeliveryAddressPageSupport elementLink(String link) {
        $$(".DesktopDiscoveryTabLink__StyledNavLink-sc-1qoyay1-0").find(Condition.href(link))
                .shouldHave(Condition.href(link));
        return this;
    }

    @Step ("Element from SubNavigation section has blue filling")
    public DeliveryAddressPageSupport elementBlueFilling(String element) {
        $$(".iMVcLF").find(Condition.href(element)).shouldHave(Condition.href(element));
        return this;
    }

    @Step ("Element from SubNavigation section has no filling")
    public DeliveryAddressPageSupport elementWithoutFilling(String element) {
        $$(".iTHVni").find(Condition.href(element)).shouldHave(Condition.href(element));
        return this;
    }

    @Step ("Cheking the Unlimited Deliveried tile is in place")
    public DeliveryAddressPageSupport unlimitedDeliveriesTile() {
        $$(".ImageWithBlurHashTransition__StyledImage-sc-58sbex-1").findBy(Condition.attribute("src",
                        "https://imageproxy.wolt.com/wolt-frontpage-images/content_editor/banners/images/3ea4ab24-74bc-11ed-a0b9-5adf0be8436e_7955f2b0_f012_489d_8765_e8f3013bf7f4.png"))
                .shouldHave(Condition.attribute("src", "https://imageproxy.wolt.com/wolt-frontpage-images/content_editor/banners/images/3ea4ab24-74bc-11ed-a0b9-5adf0be8436e_7955f2b0_f012_489d_8765_e8f3013bf7f4.png"));
        return this;
    }

    @Step ("Checking the category button is disabled")
    public DeliveryAddressPageSupport buttonElementDisabled() {
        $$(".Header-module__prevNextButton___iuJ0q").findBy(Condition.attribute("disabled"))
                .shouldHave(Condition.attribute("disabled"));
        return this;
    }

    @Step ("Checking the category button is enabled")
    public DeliveryAddressPageSupport buttonElementEnabled() {
        $$(".Header-module__prevNextButton___iuJ0q").findBy(Condition.attribute("aria-label", "Next"))
                .shouldHave(Condition.attribute("aria-label", "Next")).shouldNotHave(Condition.attribute("disabled"));
        return this;
    }

    @Step ("Section has heading")
    public DeliveryAddressPageSupport sectionHeading(String heading) {
        $$(".Header__Heading-sc-1qa68ul-0").findBy(Condition.text(heading)).shouldHave(Condition.text(heading));
        return this;
    }

    @Step ("Quick links section has heading")
    public DeliveryAddressPageSupport quickLinksHeading(String heading) {
        $(".QuickLinks__ListTitle-sc-jkimc8-0").shouldHave(Condition.text(heading));
        return this;
    }

    @Step ("Quick links section has 'sending gift' text")
    public DeliveryAddressPageSupport sendingGift(String text) {
        $(".QuickLinks-module__itemWrapper____Ne1r").$(".QuickLinks-module__title___PnYTc")
                .shouldHave(Condition.text(text));
        return this;
    }

    @Step ("Quick links section has link")
    public DeliveryAddressPageSupport sendingGiftLink(String link) {
        $(".QuickLinks-module__itemWrapper____Ne1r").$(".DiscoveryLink-module__link___bg0bC")
                .shouldHave(Condition.href(link));
        return this;
    }

    @Step ("Category Tile link")
    public DeliveryAddressPageSupport categoryTile(String link) {
        $$(".LinkWithLocale__StyledLink-sc-1xr70lo-0").find(Condition.href(link))
                .shouldHave(Condition.href(link));
        return this;
    }

    @Step ("Category Tile Header")
    public DeliveryAddressPageSupport categoryTileHeader(String text) {
        $$(".CategoryCardBody__Header-sc-1quwqfy-2").filterBy(Condition.text(text))
                .shouldHave(CollectionCondition.texts(text));
        return this;
    }

    @Step ("Logo of the Kiosky's supermarket")
    public DeliveryAddressPageSupport kioskysSupermarketLogo() {
        $$(".ImageWithBlurHashTransition__StyledImage-sc-58sbex-1").findBy(Condition.attribute("src",
                        "https://imageproxy.wolt.com/wolt-frontpage-images/cities/helsinki/sections/1ce76eac-fe99-11ec-9cce-4a7e419f12b8_nvfhjfg___copy.jpg"))
                .shouldHave(Condition.attribute("src", "https://imageproxy.wolt.com/wolt-frontpage-images/cities/helsinki/sections/1ce76eac-fe99-11ec-9cce-4a7e419f12b8_nvfhjfg___copy.jpg"));
        return this;
    }

    @Step ("Scroll to the category tile")
    public DeliveryAddressPageSupport categoryTileScroll(String link) {
        $$(".LinkWithLocale__StyledLink-sc-1xr70lo-0").find(Condition.href(link))
                .shouldHave(Condition.href(link)).scrollTo();
        return this;
    }

    @Step ("Hover above the Tile header")
    public DeliveryAddressPageSupport categoryTileHeaderHover(String text) {
        $$(".CategoryCardBody__Header-sc-1quwqfy-2").find(Condition.text(text)).hover();
        return this;
    }

    @Step ("Check that tile enlarges")
    public DeliveryAddressPageSupport categoryTileEnlarge() {
        $$(".CategoryCard__Root-sc-1witavj-0").find(Condition.attribute("style",
                "transform: scale(1.03) translateZ(0px);")).shouldHave(Condition.attribute("style",
                "transform: scale(1.03) translateZ(0px);"));
        return this;
    }
}