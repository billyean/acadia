/*
 * Copyright [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.dp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestLongestIncreasingSubsequence {
    @DataProvider
    public Object[][] longestIncreasingSubsequenceTestObjects(){
        return new Object[][] {
                {new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}, 6}
        };
    }
    @Test(dataProvider = "longestIncreasingSubsequenceTestObjects")
    public void test(int[] testArray, int longestSubsequenceLength) {
        assertEquals(LongestIncreasingSubsequence.longest(testArray), longestSubsequenceLength);
    }
}
