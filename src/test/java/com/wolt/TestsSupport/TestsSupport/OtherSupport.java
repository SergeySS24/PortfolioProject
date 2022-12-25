package com.wolt.TestsSupport.TestsSupport;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class OtherSupport {

    @Step("Check that API request to the selected link returns code 200")
    public OtherSupport status200Check(String link) {
        given()
                .get(link)
                .then()
                .statusCode(200);
        return this;
    }

}

