package com.jaemzware;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import static org.hamcrest.Matchers.lessThan;

import static io.restassured.RestAssured.given;


/**
 * Hello world!
 *
 */
public class BaseTest
{
    protected String username = "jimarasim";
    protected String password = "";

    protected RequestSpecification requestWithCredentialsSpec;
    protected ResponseSpecification responseBasicSpec;

    @BeforeClass
    public void initPath() {

        RestAssured.baseURI = "https://api.github.com";

        requestWithCredentialsSpec = given().auth().preemptive().basic(username,password);

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecBuilder.expectResponseTime(lessThan(1500L));
        responseBasicSpec = responseSpecBuilder.build();
    }
}
