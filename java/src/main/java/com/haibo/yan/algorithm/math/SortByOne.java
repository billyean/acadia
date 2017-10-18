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

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * We have a int array, please sort the array based one the number of 1 in it's binary representation
 */
public class SortByOne {
    public static int[] sort(int[] array) {
        Integer[] integers = IntStream.of(array).mapToObj(Integer::valueOf).toArray(Integer[]::new);
        Arrays.sort(integers,
                Comparator.comparing(SortByOne::numberOfOne));
        return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
    }

    /**
     * Fenwick tree implementation to get number of one.
     * @param intv
     * @return
     */
    public static int numberOfOne(int intv) {
        int one = 0;

        while(intv != 0) {
            intv -= (intv) & (-intv);
            one++;
        }

        return one;
    }
}
