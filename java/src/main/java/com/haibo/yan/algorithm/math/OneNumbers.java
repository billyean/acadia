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

package com.haibo.yan.algorithm.math;

public class OneNumbers {
    /**
     * Fenwick tree solution for count one number in binaries representation
     *
     * @param i an integer to calculate one's number.
     * @return numbers of one in integer i's binary representation.
     */
    public static int countDigits(int i) {
        int count = 0;

        while (i != 0) {
            int lsb = -i & i;
            if (i < 0)
                lsb = -lsb;
            count++;
            i -= lsb;
        }

        return count;
    }
}
