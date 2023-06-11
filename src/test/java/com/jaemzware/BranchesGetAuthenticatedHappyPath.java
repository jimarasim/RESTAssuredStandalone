package com.jaemzware;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.AnyOf.anyOf;

/**
 * Created by jameskarasim on 7/17/17.
 */
public class BranchesGetAuthenticatedHappyPath extends BaseTest{
    @Test
    public void BranchesGetAuthenticatedHappyPathTest(){
        //extract a list of all repo urls
        List<String> privateRepoUrls = requestWithCredentialsSpec.
                when().
                get("/user/repos").
                then().
                spec(responseBasicSpec).
                extract().path("html_url");

        //shorten urls to the repo name only
        List<String> privateRepoNames = new ArrayList<String>();
        for(String repo:privateRepoUrls) {
            String nameOnly = repo.substring(repo.lastIndexOf('/')+1);
            privateRepoNames.add(nameOnly);
            System.out.println(nameOnly);
        }

        //list the branches for each repo name
        for(String repo:privateRepoNames){
            List<String> branches = requestWithCredentialsSpec.
                    pathParam("repoName",repo).
                    when().
                    get("/repos/jimarasim/{repoName}/branches").
                    then().
                    log().body().
                    spec(responseBasicSpec).
                    body("name", anyOf(hasItem("main"), hasItem("master"), hasItem("develop"))).
                    extract().path("name");
        }
    }
}
