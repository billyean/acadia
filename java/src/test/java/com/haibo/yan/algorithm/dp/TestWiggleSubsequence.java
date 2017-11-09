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

package com.haibo.yan.algorithm.dp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestWiggleSubsequence {
    @DataProvider
    public Object[][] wiggleArray() {
        return new Object[][]{
                {new int[]{1, 7, 4, 9, 2, 5}, 6},
                {new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2}
        };
    }

    @Test(dataProvider = "wiggleArray")
    public void test(int[] wiggles, int len) {
        assertEquals(new WiggleSubsequence().wiggleMaxLength(wiggles), len);
    }
}
