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

import static org.testng.Assert.assertEquals;

public class TestSearchRange {
    @DataProvider
    public Object[][] rangeObjects() {
       return new Object[][]{
               {new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}}
       };
    }

    @Test(dataProvider = "rangeObjects")
    public void test(int[] array, int target, int[] expected) {
        int[] range = new SearchRange().searchRange(array, target);

        assertEquals(range.length, expected.length);

        for (int i = 0; i < range.length; i++) {
            assertEquals(range[i], expected[i], String.format("actual[%d] = %d, expected[%d] = %d", i, range[i], i, expected[i]));
        }
    }
}
