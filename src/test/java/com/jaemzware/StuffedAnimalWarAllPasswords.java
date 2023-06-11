package com.jaemzware;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by jameskarasim on 7/16/17.
 */
public class StuffedAnimalWarAllPasswords extends BaseTest {
    @Test
    public void StuffedAnimalWarPostHappyPathTest() throws Exception{
        RestAssured.baseURI = "https://stuffedanimalwar.com:55555";
        String password = "clown";
        //QUERY FOR ALL PASSWORDS
        List<String> allPasswords = given().
                when().
                get("/passwords").
                then().
                log().all().
                spec(responseBasicSpec).
                extract().path("password");
        for(String aPassword : allPasswords){
            given().
                    queryParam("credential",aPassword).
                    when().
                    get("/stuffedanimalwarpassword").
                    then().log().all().spec(responseBasicSpec).
                    body("payload", Matchers.everyItem(Matchers.notNullValue()));
        }

    }
}
