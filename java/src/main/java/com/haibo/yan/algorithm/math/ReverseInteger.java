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

/**
 *
 * see https://leetcode.com/problems/reverse-integer/
 *
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x < 10 && x > -10) return x;

        long y = x;

        long i = 1;

        while ((y = y / 10) != 0) {
            i = i * 10;
        }

        y = 0;
        long xy = x;
        long j = 1;
        while (i > 0) {
            long q = xy / i;
            y = y + q * j;
            xy %= i;
            i = i / 10;
            j *= 10;
        }

        return  (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) ? 0 : (int)y;
    }

}
