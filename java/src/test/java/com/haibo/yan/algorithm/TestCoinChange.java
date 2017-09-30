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

package com.haibo.yan.algorithm;

import com.haibo.yan.algorithm.dp.CoinChange;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static org.testng.Assert.assertEquals;

public class TestCoinChange {
    @DataProvider
    public Object[][] coins() {
        return new Object[][]{
                {new int[]{1, 2, 5}, 11, 3},
                {new int[]{1}, 0, 0},
                {new int[]{2}, 4, 2},
                {new int[]{2}, 1, -1},
                {new int[]{2}, 3, -1},
                {new int[]{1, Integer.MAX_VALUE}, 2, 2},
                {new int[]{456, 117, 5, 145}, 1459, 23},
        };
    }

    @Test(dataProvider = "coins")
    public void test(int[] coins, int amount, int expected) {
        assertEquals(CoinChange.coinChange(coins, amount), expected,
                String.format("coins = %s, amount = %d",
                        IntStream.of(coins).mapToObj(String::valueOf).collect(joining(",", "[", "]")),
                        amount));
    }
}
