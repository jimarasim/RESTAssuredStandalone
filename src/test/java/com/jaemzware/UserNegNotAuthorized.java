package com.jaemzware;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by jameskarasim on 7/16/17.
 */
public class UserNegNotAuthorized extends BaseTest{
    @Test
    public void UserNegNotAuthorizedTest() throws Exception{
        when().
                get("/user").
                then().
                log().all().
                statusCode(401).
                body("message",equalTo("Requires authentication"));
    }
}
