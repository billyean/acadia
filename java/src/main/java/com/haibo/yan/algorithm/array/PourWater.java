package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/pour-water/
 */
public class PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            if (!goLeft(heights, K) && !goRight(heights, K)) {
                heights[K]++;
            }
        }

        return heights;
    }

    private boolean goLeft(int[] heights, int K) {
        int i = K;
        int h = heights[K];
        while (i > 0 && heights[i - 1] <= h) {
            i--;
            if (heights[i] < h) {
                h = heights[i];
            }
        }
        if (heights[i] < heights[K]) {
            while (heights[i + 1] == heights[i]) {
                i++;
            }
            heights[i]++;
            return true;
        }
        return false;
    }

    private boolean goRight(int[] heights, int K) {
        int i = K;
        int h = heights[K];
        while (i  < heights.length - 1 && heights[i + 1] <= h) {
            i++;
            if (heights[i] < h) {
                h = heights[i];
            }
        }
        if (heights[i] < heights[K]) {
            while (heights[i - 1] == heights[i]) {
                i--;
            }
            heights[i]++;
            return true;
        }
        return false;
    }
}
