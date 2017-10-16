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

package com.haibo.yan.algorithm.dp;

import java.util.Stack;

/**
 *
 * See https://leetcode.com/problems/largest-rectangle-in-histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, findInTwo the area
 * of largest rectangle in the histogram.
 * Consider a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 *
 */
public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int index = 0;

        int maxArea = 0;

        /**
         * Here in stack store all bars whose height is smaller than current. If there is no bars smaller than current
         * bar, smallest height will be stored.
         * Tricky part is in bottom of stack store the smallest bar height
         */
        while (index < heights.length) {
            if (stack.isEmpty() || heights[index] > heights[stack.peek()]) {
                stack.push(index++);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top]  * (stack.isEmpty() ? index : index - stack.peek() - 1));
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            maxArea = Math.max(maxArea, heights[top]  * (stack.isEmpty() ? index : index - stack.peek() - 1));
        }

        return maxArea;
    }
}
