package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 */
public class BeautifulArrangement {
    public int[] constructArray(int n, int k) {
        int[] r = new int[n];
        int x = 0;
        while (x < n - k) {
            r[x] = x + 1;
            x++;
        }

        int i = x;
        int j = n - 1;
        while (i <= j) {
            r[x++] = j + 1;
            j--;
            if (i <= j) {
                r[x++] = i + 1;
                i++;
            }
        }

        return r;
    }
}
