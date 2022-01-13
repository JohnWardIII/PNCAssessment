package com.restcountries.utilites;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;

public class RestCountriesTestBase {
    @BeforeAll
    public static void init(){
        baseURI = ConfigurationReader.getProperty("rest_countries_api");

    }

    public static ResponseSpecification countryCheck(){
        return expect()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .logDetail(LogDetail.ALL);
    }


    @AfterAll
    public static void reset(){
        RestAssured.reset();
    }
}
