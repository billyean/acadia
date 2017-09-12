package com.haibo.yan.algorithm.string;

import com.haibo.yan.algorithm.string.Isomorphic;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class TestIsomorphic {
    @DataProvider
    public Object[][] stringsResult() {
        return new Object[][] {
                {"add", "egg", true} ,
                {"foo", "bar", false},
                {"add1", "egg", false},
                {"addee", "egggg", false},
                {"adddd", "eggdd", false},
        };
    }

    @Test(dataProvider = "stringsResult")
    public void testIsomorphic(String string1, String string2, boolean isIsomorphic) {
        assertEquals(new Isomorphic().isIsomorphic(string1, string2), isIsomorphic);
    }
}
