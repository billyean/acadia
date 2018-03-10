package com.haibo.yan.algorithm.dp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.testng.Assert.assertEquals;

public class TestMarblesThreeBaskets {
    @DataProvider
    public Object[][] marbles() {
        return new Object[][]{
                {new int[]{6, 7, 11}, 3},
                {new int[]{15, 18, 3}, 2},
                {new int[]{5, 6, 7}, Integer.MAX_VALUE},
        };
    }
    @Test(dataProvider = "marbles")
    public void test(int[] marbles, int step) {

        assertEquals(step, new MarblesThreeBaskets().minStep(marbles));
    }
}
