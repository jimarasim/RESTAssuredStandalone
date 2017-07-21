package com.jaemzware;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by jameskarasim on 7/16/17.
 */
public class ReposGetAnonymousHappyPath extends BaseTest {
    @Test
    public void ReposGetAnonymousHappyPathTest() throws Exception{
        requestWithCredentialsSpec.
        when().
                get("/users/facebook/repos").
                then().
                log().all().
                spec(responseBasicSpec).
                body("owner[0].login",equalTo("facebook"));
    }
}
