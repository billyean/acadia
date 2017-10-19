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

import java.util.*;
import java.util.stream.IntStream;

class UglyNumber {
    /**
     *
     * see https://leetcode.com/problems/ugly-number
     *
     * Write a program to check whether a given number is an ugly number.
     *
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14
     * is not ugly since it includes another prime factor 7.
     * Note that 1 is typically treated as an ugly number.
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num < 1)
            return false;
        // Write your code here
        if (num == 1) {
            return true;
        }

        if (num % 2 == 0) {
            return isUgly(num / 2);
        }

        if (num % 3 == 0) {
            return isUgly(num / 3);
        }

        if (num % 5 == 0) {
            return isUgly(num / 5);
        }

        return false;
    }

    /**
     * see https://leetcode.com/problems/ugly-number-ii
     *
     * Write a program to find the n-th ugly number.
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
     * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        if (n < 1) throw new IllegalArgumentException("n can't be less than 1");

        if (n == 1) return 1;

        int i = 1, next = 1;

        ArrayList<ValueNext> list = new ArrayList<>();
        list.add(new ValueNext(1));

        while (i < n) {
            int min = (int)list.stream().filter(vn -> vn.next < 3).mapToLong(vn -> next(vn.value, vn.next)).min().getAsLong();
            next = min;

            for (ValueNext vn: list) {
                if (min % vn.value == 0 &&
                        (min / vn.value == 2 || min / vn.value == 3 || min / vn.value == 5)) {
                    vn.next++;
                }
            }

            list.add(new ValueNext(min));
            i++;
        }

        return next;
    }

    private long next(int v, int n) {
        if (n == 0) {
            return 2L * v;
        }
        if (n == 1) {
            return 3L * v;
        }
        if (n == 2) {
            return 5L * v;
        }
        return -1;
    }

    /**
     *
     * TODO: performace issue, need refactor
     *
     * see https://leetcode.com/problems/super-ugly-number
     * Write a program to find the nth super ugly number.
     * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
     * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given
     * primes = [2, 7, 13, 19] of size 4.
     * Note:
     * (1) 1 is a super ugly number for any given primes.
     * (2) The given numbers in primes are in ascending order.
     * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
     * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 1) throw new IllegalArgumentException("n can't be less than 1");

        if (n == 1) return 1;

        int i = 1, next = 1;

        ArrayList<ValueNext> list = new ArrayList<>();
        list.add(new ValueNext(1));

        while (i < n) {
            int min = (int)list.stream().filter(vn -> vn.next < primes.length)
                    .mapToLong(vn -> (long)vn.value * primes[vn.next]).min().getAsLong();
            next = min;

            for (ValueNext vn: list) {
                if (min % vn.value == 0 &&
                        IntStream.of(primes).filter(p -> p == min / vn.value).findAny().isPresent()) {
                    vn.next++;
                }
            }

            list.add(new ValueNext(min));
            i++;
        }

        return next;
    }

    class ValueNext {
        int value;

        int next;

        ValueNext(int value) {
            this.value = value;
            this.next = 0;
        }
    }
}
