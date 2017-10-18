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

/**
 * Giving a array which has zero and no-zero elements, move all zero elements to the end and no-zero elements to the
 * begin. Also please keep original order of no zero values
 */
public class MoveZeroes {
    public static void  move(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int p1 = 0, p2 = 0;

        while (p2 < array.length) {
            while (p2 < array.length && array[p2] == 0) {
                p2++;
            }

            if (p2 < array.length) {
                array[p1] = array[p2];
                p1++;
                p2++;
            }
        }

        for (int i = p1; i < array.length; i++) {
            array[i] = 0;
        }
    }
}
