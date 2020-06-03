package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        int n = A.length;
        List<Integer> flipped = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int x = 0;
            for (int j = 1; j < n + 1 - i; j++) {
                if (A[j] > A[x]) {
                    x = j;
                }
            }
            if (x != n - i) {
                reverse(A, x);
                if (x > 0) flipped.add(x + 1);
                reverse(A,  n - i);
                if (n - i > 0) flipped.add(n - i + 1);
            }
        }
        return flipped;
    }

    private void reverse(int[] A, int index) {
        int left = 0, right = index;
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }
}
