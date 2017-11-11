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

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * This us following the problem of bitop/SingleNumber
 * The problem:
 *
 * Given an array of integers, every element appears k times except for one. Find that single one.
 */
public class SingleNumber {
    /**
     * Using mod operation here, convert array to K bits int, every bit will be sum(bit) % k.
     *
     * @param array
     * @param k
     * @return
     */
    public static int findInK(int[] array, int k) {
        int[] kbits = new int[32];

        for (int i = 0; i < array.length; i++) {
            addVtoKBits(array[i], k, kbits);
        }

        mod(kbits, k);
        return kbitToInt(kbits, k);
    }

    private static void addVtoKBits(int v, int k, int[] kbits) {
        int i = 0;
        while (v != 0) {
            kbits[i++] += v % k;
            v /= k;
        }
    }

    private static void mod(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            array[i] %= k;
        }
    }

    private static int kbitToInt(int[] array, int k) {
        int v = 0;

        int kp = 1;

        for (int i = 0; i < array.length; i++) {
            v += array[i] * kp;
            kp *= k;
        }

        return v;
    }
}
