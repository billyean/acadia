package com.haibo.yan.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestReverseInteger {
    @DataProvider
    public Object[][] reverseNumbers() {
        return new Object[][] {
                {12345, 54321},
                {1234, 4321},
                {1, 1},
                {0, 0},
                {Integer.MIN_VALUE, 0},
                {Integer.MAX_VALUE, 0},
        };
    }

    @Test(dataProvider = "reverseNumbers")
    public void testReverseNumber(int number, int expected) {
        assertEquals(new ReverseInteger().reverse(number), expected);
    }
}
