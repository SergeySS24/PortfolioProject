package com.wolt.Tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class Practicetests {

    //@Test
   // void pictureCheck() {

         //List links=driver.findElements(By.tagName("img"));
        // this will display list of all images exist on page
         // for(WebElement ele:links){
         //  System.out.println(ele.getAttribute("src"));
    }
    // .shouldHave(Condition.attribute("img", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));

    //.find(Condition.attribute("img src", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));



    // $(".CountryFrontHeroBanner-module__root___txolf").$("img")
    //       .shouldHave(Condition.image);

    // .shouldHave(Condition.image);

    //.$(".img src")
    // .shouldHave(Condition.attributeMatching("img src", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));


    // $("image")
    //  .shouldBe(Condition.image"https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg");



//    HashMap cities=new HashMap<String, String>();
//               cities.put("key1", "Ammochostos");
//                cities.put("key2", "Larnaca");
//                cities.put("key3", "Limassol");
//                cities.put("key4", "Nicosia");
//                cities.put("key5", "Paphos");
//
//
//    String s = null;
//                for (Object city: cities.values()) {
//        s = (String) city;
//
//    }
//                System.out.println(s);

/*
    @ValueSource(strings = {"Ammochostos", "Larnaca", "Limassol", "Nicosia", "Paphos"})
    @ParameterizedTest(name = "Check all cities")
    void checkTowns(String cities) {
        $$(".CitySelection-module__contentWrapper___BWfyh").find(Condition.text(cities)).shouldBe(Condition.visible);
    }


   }
   }
 */

