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

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class SlidingWindow {
    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very
     * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     * <p>
     * For example,
     * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     * <p>
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * Therefore, return the max sliding window as [3,3,5,5,6,7].
     * Note:
     * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
     * The deque only preserve the indices that which element is greater than the element to be added.
     * also remove head from deque once the range between head and current index is greater than K.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);


            if (i + 1 >= k)
                result[i + 1 - k] = nums[deque.peek()];
        }

        return result;
    }

    /**
     * Median is the middle val in an ordered integer list. If the size of the list is even, there is no middle val.
     * So the median is the mean of the two middle value.
     * Examples:
     * [2,3,4] , the median is 3
     * [2,3], the median is (2 + 3) / 2 = 2.5
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
     * very right. You can only see the k numbers in the window. Each time the sliding window moves right by one
     * position. Your job is to output the median array for each window in the original array.
     * For example,
     * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     * Window position                Median
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       1
     * 1 [3  -1  -3] 5  3  6  7       -1
     * 1  3 [-1  -3  5] 3  6  7       -1
     * 1  3  -1 [-3  5  3] 6  7        3
     * 1  3  -1  -3 [5  3  6] 7        5
     * 1  3  -1  -3  5 [3  6  7]       6
     * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
     * Note:
     * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
     *
     * @param nums
     * @param k
     * @return
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new double[0];

        double[] result = new double[nums.length - k + 1];

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Comparator.comparing(Integer::intValue).reversed());

        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0) {
                int d = nums[i - k];
                if (!minQueue.remove(d)) {
                    maxQueue.remove(d);
                }
            }

            while (maxQueue.size() > minQueue.size() + 1) {
                minQueue.add(maxQueue.poll());
            }

            while (minQueue.size() > maxQueue.size() + 1) {
                maxQueue.add(minQueue.poll());
            }

            if (minQueue.isEmpty() || minQueue.peek() < nums[i]) {
                minQueue.add(nums[i]);
            } else {
                maxQueue.add(nums[i]);
            }

            while (maxQueue.size() > minQueue.size() + 1) {
                minQueue.add(maxQueue.poll());
            }

            while (minQueue.size() > maxQueue.size() + 1) {
                maxQueue.add(minQueue.poll());
            }

            int n = i + 1 - k;
            if (n >= 0) {
                if (minQueue.size() > maxQueue.size()) {
                    result[n] = minQueue.peek();
                } else if (minQueue.size() < maxQueue.size()) {
                    result[n] = maxQueue.peek();
                } else {
                    result[n] = ((double) minQueue.peek() + (double) maxQueue.peek()) / 2.0;
                }

            }
        }
        return result;
    }
}
