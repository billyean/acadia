package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class ReplaceGreatestElementRight {
    public int[] replaceElements(int[] arr) {
        int p = 0;
        int m = arr[p];
        int mp = 0;
        while (++p < arr.length) {
            if (arr[p] > m) {
                m = arr[p];
                mp = p;
            }
        }
        int min = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= mp && i > 0; i --) {
            if (arr[i] > arr[i - 1]) {
                arr[i - 1] = arr[i];
            }
        }
        for (int i = 0; i < mp; i++) {
            arr[i] = arr[mp];
        }
        for (int i = mp; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length -1] = -1;
        return arr;
    }
}
