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

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class TestKnapsack {
    @DataProvider
    public Object[][] knapsackDataProvider() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(3, 4);
        map.put(4, 5);
        map.put(5, 7);
        return new Object[][]{
                {map, 7, 9 }
        };
    }

    @Test(dataProvider = "knapsackDataProvider")
    public void test(HashMap<Integer, Integer> map, int total, int expected) {
        assertEquals(Knapsack.mostValue(map, total), expected);
    }
}
