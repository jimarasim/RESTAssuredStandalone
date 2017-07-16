package com.jaemzware;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;



/**
 * Created by jameskarasim on 7/16/17.
 */
public class ReposGetAuthenticatedHappyPath extends BaseTest {
    @Test
    public void ReposGetAuthenticatedHappyPathTest(){
        requestWithCredentialsSpec.
                when().
                get("/user/repos").
                then().
                log().all().
                spec(responseBasicSpec).
                body("id",hasSize(greaterThan(10)));
    }
}
