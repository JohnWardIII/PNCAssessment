package com.restcountries.tests;

import com.restcountries.utilites.RestCountriesTestBase;
import io.restassured.http.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test1 extends RestCountriesTestBase {

    Response response = get("capital/lima");

    @Test
    public void test1(){
        given()
                .accept(ContentType.JSON)
        .when()
                .get("/capital/lima")
        .then()
                .spec(countryCheck());
    }

    @Test
    public void test2(){
        System.out.println(response.statusCode());
        assertTrue(response.body().asString().contains("Peru"));
    }

    @Test
    public void test3() {
        given()
                .accept(ContentType.JSON)
        .when()
                .get("/alpha?codes=pe")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name.common", contains("Peru"))
                .log().all();
    }
    //TODO
    //Tests to check for null and non-existent user inputs.
    //Tests to check for cca2 codes less than or longer than 2 characters and non-alphabetical
    //Tests to check for ccn3 that are less than and longer than 3 numbers, and non-numerical
    //Tests to check for ca3, cioc that are less than and longer than 3 characters, and non-alphabetical
    //NOTE: Not every country has a cioc code
}
