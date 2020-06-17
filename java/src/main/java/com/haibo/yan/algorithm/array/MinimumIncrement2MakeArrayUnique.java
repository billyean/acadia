package com.haibo.yan.algorithm.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 */
public class MinimumIncrement2MakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int owe = 0;
        int step = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                owe++;
                step -= A[i];
            } else {
                int give = Integer.min(A[i + 1] - A[i] - 1, owe);
                owe -= give;
                step += (2 * A[i] + give + 1) * give / 2;
            }
        }
        if (owe > 0) {
            step += (2 * A[A.length - 1] + owe + 1) * owe / 2;
        }

        return step;
    }
}
