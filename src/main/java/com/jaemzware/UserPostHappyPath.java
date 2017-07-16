package com.jaemzware;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by jameskarasim on 7/16/17.
 */
public class UserPostHappyPath extends BaseTest {
    @Test
    public void UserPostHappyPathTest() throws Exception{
        //extract the current blog url
        String currentBlogUrl = requestWithCredentialsSpec.
                when().
                get("/user").
                then().
                log().all().
                spec(responseBasicSpec).
                extract().
                path("blog");

        //set blog url to something different
        String setBlogUrl = currentBlogUrl.equals("https://seattlerules.com")?"http://jaemzware.com":"https://seattlerules.com";

        //post and verify the blog url was set
        requestWithCredentialsSpec.
                when().
                body("{\"blog\":\""+setBlogUrl+"\"}").
                post("/user").
                then().
                log().all().
                spec(responseBasicSpec).
                and().
                body("blog",equalTo(setBlogUrl));

        //verify again with a get request
        requestWithCredentialsSpec.
                when().
                get("/user").
                then().
                log().all().
                spec(responseBasicSpec).
                and().
                body("blog",equalTo(setBlogUrl));
    }
}
