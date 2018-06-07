package com.haibo.yan.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestBigIntMedian {
    @DataProvider
    public Object[][] medianProvider() {
        return new Object[][] {
            {Arrays.asList(Integer.MIN_VALUE, 0, Integer.MIN_VALUE), 0},
            {Arrays.asList(1, 1, 1, 2, 2), 1}
        };
    }

    @Test(dataProvider ="medianProvider")
    public void test(List<Integer> testData, int expectedMedian) {
        assertEquals(new BigIntMedian().median(testData), expectedMedian);
    }
}
