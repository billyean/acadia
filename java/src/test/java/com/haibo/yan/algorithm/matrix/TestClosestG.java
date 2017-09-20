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

package com.haibo.yan.algorithm.matrix;

import com.haibo.yan.algorithm.matrix.ClosestG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestClosestG {
    @DataProvider
    public Object[][] closestGMatrix() {
        return new Object[][]{
                {new char[][]{
                        {' ', ' ', 'G', ' '},
                        {' ', ' ', ' ', ' '},
                        {'G', ' ', 'W', ' '},
                        {' ', ' ', 'W', ' '},
                        {'W', 'W', 'W', 'W'},
                        {' ', ' ', 'G', ' '}
                },
                        new int[][]{
                                {2, 1, 0, 1},
                                {1, 2, 1, 2},
                                {0, 1, Integer.MAX_VALUE, 3},
                                {1, 2, Integer.MAX_VALUE, 4},
                                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                                {2, 1, 0, 1}
                        }}
        };
    }

    @Test(dataProvider = "closestGMatrix")
    public void testClosestG(char[][] matrix, int[][] expected) {
        assertEquals(ClosestG.minSteps(matrix), expected);
    }
}
