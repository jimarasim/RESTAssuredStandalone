package com.jaemzware;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.responseSpecification;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

/**
 * Created by jameskarasim on 7/16/17.
 */
public class UsersGetSpecificUserHappyPath extends BaseTest {
    @Test
    public void UsersGetSpecificUserHappyPathTest(){
        requestWithCredentialsSpec.when().
                get("/users/jimarasim").
                then().
                log().all().
                spec(responseBasicSpec).
                header("Server",equalTo("GitHub.com")).
                body("login",equalTo("jimarasim")).
                body("location",equalTo("Seattle"));
    }
}
