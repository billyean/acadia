package com.haibo.yan.algorithm.dp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestFibonacci {
    @DataProvider
    public Object[][] fibonacciMap() {
        return new Object[][]{
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {9, 34},
                {23, 28657},
                {50, 12586269025L},
                {92, 7540113804746346429L}
        };
    }

    @Test(dataProvider = "fibonacciMap")
    public void testFibonacci(int pos, long fibonacciValue) {
        assertEquals(Fibonacci.fibonacci(pos), fibonacciValue);
    }
}
