/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.array;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.joining;
import static org.testng.Assert.assertEquals;

public class TestSlidingWindow {
    @DataProvider
    public Object[][] maxSlideWindosDP() {
        return new Object[][]{
                {new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}},
                {new int[]{}, 0, new int[]{}},
                {new int[]{1, 3, 1, 2, 0, 5}, 3, new int[]{3, 3, 2, 5}},
                {new int[]{7, 2, 4}, 2, new int[]{7, 4}},
        };
    }

    @Test(dataProvider = "maxSlideWindosDP")
    public void testMax(int[] nums, int k, int[] maxWindows) {
        assertEquals(SlidingWindow.maxSlidingWindow(nums, k), maxWindows);
    }

    @DataProvider
    public Object[][] medSlideWindosDP() {
        return new Object[][]{
                {new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new double[]{1, -1, -1, 3, 5, 6}},
                {new int[]{}, 0, new double[]{}},
                {new int[]{1, 3, 1, 2, 0, 5}, 3, new double[]{1, 2, 1, 2}},
                {new int[]{7, 2, 4}, 2, new double[]{4.5, 3}},
                {new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, 2, new double[]{Integer.MAX_VALUE}},
                {new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
                        Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                        Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE}, 3,
                new double[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
                        Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                        Integer.MIN_VALUE}}
        };
    }

    @Test(dataProvider = "medSlideWindosDP")
    public void testMed(int[] nums, int k, double[] medWindows) {
        double[] actual = SlidingWindow.medianSlidingWindow(nums, k);
        assertEquals(actual, medWindows, String.format("actual = %s, expected = %s",
                DoubleStream.of(actual).mapToObj(String::valueOf).collect(joining(",", "[", "]")),
                DoubleStream.of(medWindows).mapToObj(String::valueOf).collect(joining(",", "[", "]"))
                ));
    }
}
