package com.haibo.yan.algorithm;

import org.mockito.Mock;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class RandomColorTest {
    @DataProvider
    public Object[][] testProviders() {
        return new Object[][]{
            {Arrays.asList("Red", "Blue"), "Red", 0.1},
            {Arrays.asList("Red", "Blue"), "Red", 0.4},
            {Arrays.asList("Red", "Blue"), "Blue", 0.65},
            {Arrays.asList("Red", "Blue"), "Blue", 0.67},
            {Arrays.asList("Red", "Red", "Blue"), "Red", 0.1},
            {Arrays.asList("Red", "Red", "Blue"), "Red", 0.4},
            {Arrays.asList("Red", "Red", "Blue"), "Red", 0.65},
            {Arrays.asList("Red", "Red", "Blue"), "Blue", 0.67},
            {Arrays.asList("Red", "Blue", "Yellow"), "Red", 0.1},
            {Arrays.asList("Red", "Blue", "Yellow"), "Red", 0.3},
            {Arrays.asList("Red", "Blue", "Yellow"), "Blue", 0.5},
            {Arrays.asList("Red", "Blue", "Yellow"), "Yellow", 0.7},
            {Arrays.asList("Red", "Blue", "Yellow"), "Yellow", 0.9},
            {Arrays.asList("Red", "Red", "Blue", "Yellow"), "Red", 0.1},
            {Arrays.asList("Red", "Red", "Blue", "Yellow"), "Red", 0.3},
            {Arrays.asList("Red", "Red", "Blue", "Yellow"), "Blue", 0.5},
            {Arrays.asList("Red", "Red", "Blue", "Yellow"), "Blue", 0.7},
            {Arrays.asList("Red", "Red", "Blue", "Yellow"), "Yellow", 0.9},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow"), "Red", 0.1},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow"), "Red", 0.3},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow"), "Red", 0.5},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow"), "Blue", 0.7},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow"), "Yellow", 0.9},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow", "Red", "Red", "Red"), "Red", 0.1},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow", "Red", "Red", "Red"), "Red", 0.3},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow", "Red", "Red", "Red"), "Red", 0.5},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow", "Red", "Red", "Red"), "Red", 0.7},
            {Arrays.asList("Red", "Red", "Red", "Blue", "Yellow", "Red", "Red", "Red"), "Yellow", 0.9},
            {Arrays.asList("Red", "Blue"), "Red", 0.1},
            {Arrays.asList("Red", "Blue"), "Blue", 0.6},
            {Arrays.asList("Red"), "Red", 0.0},
            {Arrays.asList("Red"), "Red", 0.1},
            {Arrays.asList("Red"), "Red", 0.3},
            {Arrays.asList("Red", "Red"), "Red", 0.0},
            {Arrays.asList("Red", "Red"), "Red", 0.1},
            {Arrays.asList("Red", "Red"), "Red", 0.3},
            {Arrays.asList(), "", 0.0},

        };
    }

    @Test(dataProvider = "testProviders")
    public void test(List<String> colors, String expected, double seed) {
//        final Random r = mock(Random.class);
//        when(r.nextDouble()).thenReturn(seed);

        RandomColor rc = spy(new RandomColor());
        doReturn(seed).when(rc).randomBt0And1();
        String actual = rc.randomColor(colors);
        assertEquals(actual, expected);
    }
}
