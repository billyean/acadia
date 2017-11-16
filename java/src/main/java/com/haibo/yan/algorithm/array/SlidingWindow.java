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

    public String minWindowOrdered(String S, String T) {
        char[] cs = S.toCharArray(), ct = T.toCharArray();

        int[][] dp = new int[ct.length][cs.length + 1];

        for (int i = 0; i < ct.length; i++) {
            for (int j = 0; j <= cs.length; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < ct.length; i++) {
            for (int j = 1; j <= cs.length; j++) {
                if (ct[i] == cs[j - 1]) {
                    if (i == 0) {
                        dp[i][j] = j - 1;
                    } else {
                        dp[i][j] =  dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] =  dp[i][j - 1];
                }
            }
        }

        int start = -1, len = Integer.MAX_VALUE;

        for (int i = 1; i <= cs.length; i++) {
            int s = dp[ct.length - 1][i];
            if (s != -1 && i - s < len) {
                len = i - s;
                start = s;
            }
        }

        if (start == -1) {
            return "";
        } else {
            return S.substring(start, start + len);
        }

    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindowUnordered(String s, String t) {
        Deque<Integer> deque = new LinkedList<>();

        Map<Character, Integer> tm = new HashMap<>();

        for (char c : t.toCharArray()) {
            tm.put(c, tm.getOrDefault(c, 0) + 1);
        }

        int minLen = s.length() + 1, start = -1;
        char[] cs = s.toCharArray();
        int totalReach = t.length();

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (tm.containsKey(c)) {
                if (tm.get(c) != 0) {
                    tm.put(c, tm.get(c) - 1);
                    totalReach--;
                    if (totalReach == 0) {
                        int wLen = i - deque.peek() + 1;
                        if (wLen < minLen) {
                            start = deque.peek();
                            minLen = wLen;
                        }
                    }
                } else {
                    char fc = cs[deque.peek()];
                    if (fc == c) {
                        if (totalReach == 0) {
                            deque.pop();
                            deque.push(i);
                            int wLen = i - deque.peek() + 1;
                            if (wLen < minLen) {
                                start = deque.peek();
                                minLen = wLen;
                            }
                        }
                    }
                }
            }
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
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
