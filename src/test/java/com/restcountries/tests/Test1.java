package com.restcountries.tests;

import com.restcountries.utilites.RestCountriesTestBase;
import io.restassured.http.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import io.restassured.*;
import io.restassured.filter.log.LogDetail;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Test1 extends RestCountriesTestBase {

    @Test
    public void test1(){
        given()
                .accept(ContentType.JSON)
        .when()
                .get("/capital/lima")
        .then()
                .spec(userCheck());
    }

    @Test
    public void test2(){
        Response response = get("capital/lima");
        System.out.println(response.statusCode());
        assertTrue(response.body().asString().contains("Peru"));
    }
}
