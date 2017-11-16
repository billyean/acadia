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

package com.haibo.yan.algorithm.matrix;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestSpiralMatrix {
    @DataProvider
    public Object[][] matrixToSpiralLine() {
        return new Object[][]{
                {new int[][]{ {1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}},
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)},
                {new int[][]{ {1, 2, 3, 4, 5}, {14, 15, 16, 17, 6}, {13, 20, 19, 18, 7}, {12, 11, 10, 9, 8}},
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)},
                {new int[][]{ {1, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 6}, {9, 8, 7}},
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)},

        };
    }

    @Test(dataProvider = "matrixToSpiralLine")
    public void test1(int[][] matrix, List<Integer> expectedSpiral) {
        assertEquals(new SpiralMatrix().spiralOrder(matrix), expectedSpiral);
    }

    @DataProvider
    public Object[][] nToMatrix() {
        return new Object[][]{
                {1, new int[][]{ {1}}},
                {2, new int[][]{ {1, 2}, {4, 3}}},
                {3, new int[][]{ {1, 2, 3}, {8, 9, 4}, {7, 6, 5}}},
                {4, new int[][]{ {1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}},
                {5, new int[][]{ {1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23,22, 21, 8},
                        {13, 12, 11, 10, 9}}},

        };
    }

    @Test(dataProvider = "nToMatrix")
    public void test2(int n, int[][] matrix) {
        assertEquals(new SpiralMatrix().generateMatrix(n), matrix);
    }
}
