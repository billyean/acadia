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

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static org.testng.AssertJUnit.assertTrue;

public class TestWiggleSort {
    @DataProvider
    public Object[][] wiggleSortArray() {
        return new Object[][]{
                {new int[]{1, 5, 1, 1, 6, 4}},
                {new int[]{1, 3, 2, 2, 3, 1}},
                {new int[]{2, 1}},
                {new int[]{1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2}},
                {new int[]{4, 5, 5, 6}},
        };
    }

    private boolean wiggleSorted(int[] array) {
        if (array.length < 3) {
            return true;
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] < array[i + 1]
                    || array[i - 1] > array[i] && array[i] > array[i + 1]){
                return false;
            }
        }
        return true;
    }

    private boolean wiggleSortedN(int[] array) {
        if (array.length < 2) {
            return true;
        }

        if (array[0] >= array[1]) {
            return false;
        }

        for (int i = 1; i < array.length; i++) {
            if ((i & 0x01) == 1 && array[i] <= array[i - 1])
                return false;
            if ((i & 0x01) == 0 && array[i] >= array[i - 1])
                return false;
        }
        return true;
    }

    @Test(dataProvider = "wiggleSortArray")
    public void testWiggleSort(int[] nums) {
        new WiggleSort().wiggleSort(nums);
        assertTrue(wiggleSorted(nums));
    }

    @Test(dataProvider = "wiggleSortArray")
    public void testWiggleSortN(int[] nums) {
        new WiggleSort().wiggleSortN(nums);
        assertTrue(String.format("%s is not wiggle sorted", IntStream.of(nums).mapToObj(String::valueOf).
                        collect(joining(",", "[", "]"))),
                wiggleSortedN(nums));
    }
}
