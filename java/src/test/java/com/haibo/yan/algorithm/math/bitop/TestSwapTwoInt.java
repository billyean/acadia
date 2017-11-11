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

package com.haibo.yan.algorithm.math.bitop;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSwapTwoInt {
    @DataProvider
    public Object[][] swapDataProvider() {
        return new Object[][]{
                {new int[]{1, 2}, new int[]{2, 1}},
                {new int[]{1, -1}, new int[]{-1, 1}},
                {new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}}
        };
    }

    @Test(dataProvider = "swapDataProvider")
    public void swap(int[] array, int[] expected) {
        SwapTwoInt.swap(array);
        assertEquals(array, expected);
    }
}
