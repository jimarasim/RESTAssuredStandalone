package com.jaemzware;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by jameskarasim on 7/17/17.
 */
public class BranchesGetAnonymousHappyPath extends BaseTest {
    @Test
    public void BranchesGetAnonymousHappyPathTest() throws Exception{
        //get the url for all of jimarasim public repos
        List<String> publicReposUrl = requestWithCredentialsSpec.when().
                get("/users/facebook/repos").
                then().
                spec(responseBasicSpec).
                extract().path("html_url");

        //shorten urls to the repo name only
        List<String> publicRepoNames = new ArrayList<String>();
        for(String repo:publicReposUrl) {
            String nameOnly = repo.substring(repo.lastIndexOf('/')+1);
            publicRepoNames.add(nameOnly);
        }

        //list the branches for each repo name
        for(String repo:publicRepoNames){
            System.out.println(repo);
            List<String> branches = requestWithCredentialsSpec.
                    pathParam("repoName",repo).
                    when().
                    get("/repos/facebook/{repoName}/branches").
                    then().
                    spec(responseBasicSpec).
                    body("name",hasItem("main")).
                    extract().path("name");
        }

    }






}
