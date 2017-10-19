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

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestContinuousSubarraySum {
    @DataProvider
    public Object[][] subarraySum() {
        return new Object[][]{
                {new int[]{23, 2, 4, 6, 7}, 6, true},
                {new int[]{23, 2, 6, 4, 7}, 6, true},
                {new int[]{23, 2, 4, 6, 7}, 7, true},
                {new int[]{23, 2, 4, 6, 7}, 23, false},
                {new int[]{23, 2, 4, 6, 7}, -6, true},
                {new int[]{0, 0}, 0, true},
        };
    }
    @Test(dataProvider = "subarraySum")
    public void test(int[] array, int sum, boolean expected) {
        Assert.assertEquals(new ContinuousSubarraySum().checkSubarraySum(array, sum), expected);
    }
}
