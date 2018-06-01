package com.haibo.yan.algorithm.string;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestMatches {
    @DataProvider
    public Object[][] matchProvider() {
        return new Object[][]{
            {"xyzxy", "airbnbairbn", true},
            {"xyzxy", "airbnbairbnb", false},
            {"ccc", "airairair", true},
            {"cccc", "airairair", false}
        };
    }

    @Test(dataProvider = "matchProvider")
    public void test(String s, String p, boolean expected) {
        assertEquals(new Matches().match(s, p), expected);
    }
}
