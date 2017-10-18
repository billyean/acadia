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

package com.haibo.yan.algorithm.geometry;

import java.util.Arrays;

/**
 * see https://leetcode.com/problems/valid-triangle-number
 *
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array
 * that can make triangles if we take them as side lengths of a triangle.
 *
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3)
            return 0;
        int n = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (valid(nums[i], nums[j], nums[k])) {
                        n++;
                    }
                }
            }
        }
        return n;
    }

    private boolean valid(int a, int b, int c) {
        int sum = a + b + c;
        int max = Math.max(a, Math.max(b, c));
        return sum - max > max;
    }

    public int triangleNumber2(int[] nums) {
        /**
         * Sort the edges for avoiding calculation
         */
        Arrays.sort(nums);

        int triangles = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int k = j + 1;
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    triangles++;
                    k++;
                }
            }
        }

        return triangles;
    }
}
