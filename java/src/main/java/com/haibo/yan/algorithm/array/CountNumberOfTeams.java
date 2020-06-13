package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/count-number-of-teams/
 */
public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int size = rating.length;

        int c = 0;
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]
                            || rating[i] > rating[j] && rating[j] > rating[k]) {
                        c++;
                    }
                }
            }
        }

        return c;
    }
}
