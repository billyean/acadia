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

import com.haibo.yan.algorithm.TestUtilities;
import com.haibo.yan.algorithm.array.MoveZeroes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestMoveZeroes {
    @DataProvider
    public Object[][] intArraies() {
        return new Object[][] {
                {new int[]{0}, new int[]{0}},
                {new int[]{1}, new int[]{1}},
                {new int[]{0, 0}, new int[]{0, 0}},
                {new int[]{1, 2, 3}, new int[]{1, 2, 3}},
                {new int[]{1, 0, 2, 0, 3, 0}, new int[]{1, 2, 3, 0, 0, 0}},
                {new int[]{1, 0, 2, 0, 3, 0, 0}, new int[]{1, 2, 3, 0, 0, 0, 0}},
                {new int[]{1, 0, 2, 0, 3, 4, 0}, new int[]{1, 2, 3, 4, 0, 0, 0}}
        };
    }

    @Test(dataProvider = "intArraies")
    public void testMoves(int[] original, int[] expected) {
        MoveZeroes.move((original));
        TestUtilities.assertEquals(original, expected);
    }
}
