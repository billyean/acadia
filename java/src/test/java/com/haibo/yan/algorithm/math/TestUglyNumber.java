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

package com.haibo.yan.algorithm.math;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestUglyNumber {
    @DataProvider
    public Object[][] superUglyDP() {
        return new Object[][]{
                {4, new int[]{2, 3, 5}, 4},
                {3, new int[]{2}, 4},
                {100000,
                        new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,
                                211,229,233,239,241,251}, 1092889481}
        };
    }

    @Test(dataProvider = "superUglyDP")
    public void testSuperUgly(int n, int[] primes, int expected) {
        assertEquals(new UglyNumber().nthSuperUglyNumber(n, primes), expected);
    }
}
