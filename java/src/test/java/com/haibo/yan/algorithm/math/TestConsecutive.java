package com.haibo.yan.algorithm.math;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestConsecutive {
    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {15, 3},
                {10, 1},
                {250, 3}
        };
    }

    @Test(dataProvider = "testData")
    public void test(long num, int expected) {
        assertEquals(Consecutive.consecutive(num), expected);
    }
}
