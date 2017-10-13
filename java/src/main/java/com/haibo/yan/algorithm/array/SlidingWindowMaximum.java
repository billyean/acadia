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

import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 */

public class SlidingWindowMaximum {
    /**
     * The deque only preserve the indices that which element is greater than the element to be added.
     * also remove head from deque once the range between head and current index is greater than K.
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums.length == 0)
//            return nums;
//
//        int[] windows = new int[nums.length - k + 1];
//
//        LinkedList<Integer> queue = new LinkedList<>();
//
//        for (int i = 0; i < k - 1; i++) {
//            if (queue.isEmpty()) {
//                queue.offer(nums[i]);
//            } else {
//                while (!queue.isEmpty() && queue.peek() < nums[i]) {
//                    queue.poll();
//                }
//                queue.offer(nums[i]);
//            }
//        }
//
//        int i = 0;
//
//        while (i < windows.length) {
//            int n = i + k - 1;
//
//
//            if (!queue.isEmpty() && queue.peek() < nums[n]) {
//                queue.clear();
//            } else {
//                if (queue.size() == k) {
//                    queue.poll();
//
//                    int maxI = 0, max = queue.getFirst();
//                    int index = 1;
//                    ListIterator<Integer> iter = queue.listIterator(index);
//                    while (iter.hasNext()) {
//                        int next = iter.next();
//                        if (next >= max) {
//                            max = next;
//                            maxI = index;
//                        }
//                        index++;
//                    }
//
//                    if (max <= nums[n]) {
//                        queue.clear();
//                    } else {
//                        for (int m = 0; m < maxI; m++) {
//                            queue.poll();
//                        }
//                    }
//                }
//            }
//
//            queue.offer(nums[n]);
//            windows[i++] = queue.peek();
//        }
//
//        return windows;
        if (nums==null || nums.length==0)
            return new int[0];

        int[] result = new int[nums.length-k+1];

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i=0; i < nums.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();

            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }

            deque.offer(i);


            if(i + 1 >= k)
                result[i + 1 - k ] = nums[ deque.peek() ];
        }

        return result;
    }
}
