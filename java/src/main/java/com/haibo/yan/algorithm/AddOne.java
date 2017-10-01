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

/**
 *
 * Given a int array that represents positive 10-digits integer, implements add one for given array.
 * Example:
 *
 * given [1, 2, 3, 4, 5]
 * should return [1, 2, 3, 4, 6]
 *
 * given [1, 9, 9, 9]
 * should return [2, 0, 0, 0]
 *
 * given [9, 9]
 * should return [1, 0, 0]
 *
 */
public class AddOne {
    public static int[] addOne(int[] array) {
        int carrier = 1;

        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] = array[i] + carrier;
            if (result[i] > 9) {
                result[i] -= 10;
                carrier = 1;
            } else {
                carrier = 0;
            }
        }

        if (carrier == 1) {
            result = new int[array.length + 1];
            result[0] = 1;
        }

        return result;
    }
}
