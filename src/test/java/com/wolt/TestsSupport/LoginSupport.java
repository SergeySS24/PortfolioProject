package com.wolt.TestsSupport;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginSupport {

    @Step
    public LoginSupport apiTest() {
        given()
                .get("https://wolt.com/en/discovery/category/cafes")
                .then()
                .statusCode(200);
        return this;
    }

    @Step
    public LoginSupport apiTest2() {
        given()
                .get("https://imageproxy.wolt.com/wolt-frontpage-images/cities/helsinki/sections/1ce76eac-fe99-11ec-9cce-4a7e419f12b8_nvfhjfg___copy.jpg")
                .then()
                .statusCode(200);
        return this;
    }
}
