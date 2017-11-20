/*
 *
 *  * Copyright [2017] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.array;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestPartitionToEqual {
    @DataProvider
    public Object[][] partitionsArray() {
        return new Object[][] {
//                {new int[]{4, 3, 2, 3, 5, 2, 1}, 4, true},
                {new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269}, 5, true},
        };
    }

    @Test(dataProvider = "partitionsArray")
    public void test(int[] array, int k, boolean canPartition) {
        assertEquals(new PartitionToEqual().canPartitionKSubsets(array, k), canPartition);
    }
}
