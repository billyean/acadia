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

import java.util.ArrayList;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * NOTE A solution will always exist. read Goldbach’s conjecture
 * Example:
 *
 *
 * Input : 4
 * Output: 2 + 2 = 4
 *
 * If there are more than one solutions possible, return the lexicographically smaller solution.
 *
 * If [a, b] is one solution with a <= b,
 * and [c,d] is another solution with c <= d, then
 *
 * [a, b] < [c, d]
 *
 * If a < c OR a==c AND b < d.
 */
public class Primesum {
    public ArrayList<Integer> primesum(int a) {
        boolean[] primes = allPrimes(a);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= a / 2; i++) {
            if(primes[i] && primes[a-i]) {
                list.add(i);
                list.add(a - i);
                return list;
            }
        }
        return list;
    }

    /**
     * Sieve of Eratosthenes
     * @param a
     * @return
     */
    private boolean[] allPrimes(int a) {
        boolean[] primes = new boolean[a + 1];
        primes[0] = primes[1] = true;

        for (int i = 2; i <= a; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i <= a; i++) {
            if (primes[i]) {
                for (int j = 2; j * i <= a; j++) {
                    primes[j * i] = false;
                }
            }
        }
        return primes;
    }
}
