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

public class TestCoinChange {
    @DataProvider
    public Object[][] change2Provider() {
        return new Object[][]{
                {new int[]{1, 2, 5}, 5, 5},
//                {new int[]{2}, 3, 0},
//                {new int[]{10}, 10, 1},
        };
    }

    @Test(dataProvider = "change2Provider")
    public void test(int[] coins, int amount, int expectedWay){
        assertEquals(CoinChange.coinChange2(coins, amount), expectedWay);
    }
}
