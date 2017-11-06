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

import java.util.Arrays;
import java.util.Random;

/**
 *
 * See https://leetcode.com/problems/shuffle-an-array
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Shuffle shuffle = new Shuffle(nums);
 *
 * Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * shuffle.shuffle();
 *
 * Resets the array back to its original configuration [1,2,3].
 * shuffle.reset();
 *
 * Returns the random shuffling of array [1,2,3].
 * shuffle.shuffle();
 */
public class Shuffle {
    private final int[] originalNums;

    private int[] shuffleNums;

    private Random rand;

    public Shuffle(int[] nums) {
        originalNums = nums;
        shuffleNums = Arrays.copyOf(originalNums, originalNums.length);
        rand = new Random(System.currentTimeMillis());
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffleNums = Arrays.copyOf(originalNums, originalNums.length);
        return shuffleNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = shuffleNums.length; i > 0; i--) {
            int v = rand.nextInt(i);
            if (v != i - 1) {
                int t = shuffleNums[i - 1];
                shuffleNums[i - 1] = shuffleNums[v];
                shuffleNums[v] = t;
            }
        }
        return shuffleNums;
    }
}
