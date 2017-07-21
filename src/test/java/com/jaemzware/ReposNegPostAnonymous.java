package com.jaemzware;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by jameskarasim on 7/16/17.
 */
public class ReposNegPostAnonymous extends BaseTest {
    @Test
    public void ReposNegPostAnonymousTest(){
        given()
                .contentType("application/json").
        when().
                body("{\"newrepo\":\"newrepo\"").
            post("/users/facebook/repos").
            then().
            log().all().
                statusCode(404).
            body("message",equalTo("Not Found"));

    }
}
