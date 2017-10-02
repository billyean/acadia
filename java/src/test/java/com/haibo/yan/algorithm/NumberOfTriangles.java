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

import java.util.Arrays;

/**
 * You have N sticks. Given an array of their lengths, find the number of triangles that can be constructed using any
 * three of these sticks. Note that the sum of the lengths of any two sides of a triangle must be greater than the third
 * side.
 *
 * Equal triangles that are constructed from different sticks are considered different.
 * Example
 * For sticks = [3, 5, 7, 9], the output should be
 * numberOfTriangles2(sticks) = 3.
 *
 * These 3 triangles are (described by their sides): (3, 5, 7), (3, 7, 9), (5, 7, 9).
 * The triangle (3, 5, 9) is not valid, as 3 + 5 = 8 < 9.
 *
 * For sticks = [4, 4, 4, 4], the output should be
 *
 * numberOfTriangles2(sticks) = 4.
 * These 4 triangles are (4, 4, 4) made of different sticks.
 *
 * For sticks = [1, 2, 3], the output should be
 * numberOfTriangles2(sticks) = 0.
 *
 * There is only one triangle (1, 2, 3), but it is incorrect: 1 + 2 = 3.
 */
public class NumberOfTriangles {
    public static int number(int[] sticks) {
        Arrays.sort(sticks);

        int triangles = 0;

        for (int i = 0; i < sticks.length - 2; i++) {
            for (int j = i + 1; j < sticks.length - 1; j++) {
                int k = j + 1;
                while (k < sticks.length && sticks[i] + sticks[j] > sticks[k]) {
                    triangles++;
                    k++;
                }
            }
        }

        return triangles;
    }
}
