package com.haibo.yan.algorithm.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */
public class MaxArea {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int hm = 0, wm = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < horizontalCuts.length; i++) {
            if (i == 0) {
                hm = Integer.max(hm, horizontalCuts[0]);
            } else {
                hm = Integer.max(hm, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
        }
        hm = Integer.max(hm, h - horizontalCuts[horizontalCuts.length - 1]);


        for (int i = 0; i < verticalCuts.length; i++) {
            if (i == 0) {
                wm = Integer.max(wm, verticalCuts[0]);
            } else {
                wm = Integer.max(wm, verticalCuts[i] - verticalCuts[i - 1]);
            }
        }
        wm = Integer.max(wm, w - verticalCuts[verticalCuts.length - 1]);

        return (int)(((long)(hm % 1000000007) * (long)(wm % 1000000007)) % 1000000007);
    }
}
