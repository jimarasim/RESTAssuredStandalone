package com.jaemzware;

import org.testng.annotations.Test;

/**
 * Created by jameskarasim on 7/16/17.
 */
public class UserGetHappyPath extends BaseTest {
    @Test
    public void UserGetHappyPathTest() throws Exception{
        requestWithCredentialsSpec.
                when().
                get("/user").
                then().
                log().all().
                spec(responseBasicSpec);
    }
}
