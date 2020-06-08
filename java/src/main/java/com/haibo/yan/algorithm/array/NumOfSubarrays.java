package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */
public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int s = 0;
        int sm = threshold * k;

        for (int i = 0; i < k; i++) {
            s += arr[i];
        }
        int c = 0;
        if (s >= sm) {
            c++;
        }
        for (int i = k; i < arr.length; i++) {
            s -= arr[i - k];
            s += arr[i];
            if (s >= sm) {
                c++;
            }
        }

        return c;
    }
}
