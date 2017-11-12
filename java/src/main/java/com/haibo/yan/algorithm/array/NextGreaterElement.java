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

import java.util.*;

public class NextGreaterElement {
    /**
     * see https://leetcode.com/problems/next-greater-element-i
     *
     * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find
     * all the next greater numbers for nums1's elements in the corresponding places of nums2.
     *
     * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not
     * exist, output -1 for this number.
     *
     * Example 1:
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * Output: [-1,3,-1]
     * Explanation:
     * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
     * For number 1 in the first array, the next greater number for it in the second array is 3.
     * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
     * Example 2:
     * Input: nums1 = [2,4], nums2 = [1,2,3,4].
     * Output: [3,-1]
     * Explanation:
     * For number 2 in the first array, the next greater number for it in the second array is 3.
     * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
     * Note:
     * All elements in nums1 and nums2 are unique.
     * The length of both nums1 and nums2 would not exceed 1000.
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        int[] nextElements = new int[nums1.length];

        HashMap<Integer, Integer> nextMap = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            int v = nums2[i];
            int j = i + 1;
            for (; j < nums2.length; j++) {
                if (nums2[j] > v) {
                    nextMap.put(v, nums2[j]);
                    break;
                }
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nextElements[i] = nextMap.getOrDefault(nums1[i], -1);
        }

        return nextElements;
    }

    /**
     * see https://leetcode.com/problems/next-greater-element-ii
     *
     * Given a circular array (the next element of the last element is the first element of the array), print the Next
     * Greater Number for every element. The Next Greater Number of a number x is the first greater number to its
     * traversing-order next in the array, which means you could search circularly to find its next greater number. If
     * it doesn't exist, output -1 for this number.
     *
     * Example 1:
     * Input: [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number;
     * The second 1's next greater number needs to search circularly, which is also 2.
     * Note: The length of given array won't exceed 10000.
     * @param nums
     * @return
     */
    public int[] nextGreaterElementsII(int[] nums) {
        int[] nextElements = new int[nums.length];

        HashMap<Integer, Integer> nextMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int j = i + 1;
            for (; j < i + nums.length ; j++) {
                int p = j % nums.length;
                if (nums[p] > v) {
                    nextMap.put(i, nums[p]);
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nextElements[i] = nextMap.getOrDefault(i, -1);
        }

        return nextElements;
    }

    /**
     * see https://leetcode.com/problems/next-greater-element-iii
     * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits
     * existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to
     * return -1.
     *
     * Example 1:
     * Input: 12
     * Output: 21
     * Example 2:
     * Input: 21
     * Output: -1
     * @param n
     * @return
     */
    public int nextGreaterElementIII(int n) {
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % 10);
            n = n / 10;
        }
        Collections.reverse(list);

        return nextGreaterElementFromFirst(list.stream().mapToInt(Integer::valueOf).toArray());
    }

    private int nextGreaterElementFromFirst(int[] n) {
        int f = n.length - 1;

        while (f > 0) {
            if (n[f] > n[f - 1]) {
                break;
            }
            f--;
        }

        if (f != 0) {
            int a = f, m = n[a], b = f;

            while (b < n.length) {
                if (n[b] < m && n[b] > n[f - 1]) {
                    a = b;
                    m = n[a];
                }
                b++;
            }

            swap(n, f - 1, a);
            Arrays.sort(n, f, n.length);
            int j = 1;
            long v = 0;
            for (int i = n.length - 1; i >= 0; i--) {
                v += n[i] * (long)j;
                j *= 10;
            }
            return v > Integer.MAX_VALUE ? -1 : (int)v;
        } else {
            return -1;
        }
    }

    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }
}
