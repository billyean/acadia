package com.haibo.yan.algorithm.array;

import java.util.Stack;

/**
 * https://leetcode.com/problems/previous-permutation-with-one-swap/
 */
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        Stack<Integer> s = new Stack<>();
        int i = A.length - 1;
        s.push(i);
        i--;

        while (i >= 0) {
            if (A[i] == A[s.peek()]) {
                s.pop();
            } else if (A[i] > A[s.peek()]) {
                int j = s.pop();
                while(!s.isEmpty() && A[i] > A[s.peek()]) {
                    j = s.pop();
                }
                swap(A, i, j);
                return A;
            }
            s.push(i);
            i--;
        }


        return A;
    }

    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
