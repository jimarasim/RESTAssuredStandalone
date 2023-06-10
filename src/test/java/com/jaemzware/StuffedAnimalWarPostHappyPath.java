package com.jaemzware;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by jameskarasim on 7/16/17.
 */





//NOTE THIS WILL FAIL BECAUSE YOU CAN NO LONGER POST TO BLOG FROM THE API




public class StuffedAnimalWarPostHappyPath extends BaseTest {
    @Test
    public void StuffedAnimalWarPostHappyPathTest() throws Exception{
        RestAssured.baseURI = "https://stuffedanimalwar.com:55555";
        String password = "clown";
        //INSERT PASSWORD
        given().
                queryParam("credential", password).
                when().
                body("{\"fake\":\"fake\"}").
                post("/password").
                then().
                log().all().
                spec(responseBasicSpec).
                and().
                body("message", equalTo("password inserted"));
        //QUERY FOR PASSWORD
        given().
                when().
                get("/passwords").
                then().
                log().all().
                spec(responseBasicSpec).
                and().
                body("password", hasItem(password));
        //DELETE PASSWORD
        given().
                queryParam("credential",password).
                when().
                delete("/password").
                then().
                log().
                all().
                spec(responseBasicSpec).
                and().
                body("message",equalTo("password deleted"));

    }
}
