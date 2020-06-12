package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 */
public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] x = new int[s.length()];
        for(int i = 0; i <s.length(); i++) {
            x[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int max = 0;

        int j = 0;
        int cost = maxCost;
        for (int i = 0; i < x.length; i++) {
            if(i > 0) {
                cost += x[i - 1];
            }
            while (j < x.length && cost >= x[j]) {
                cost -= x[j++];
            }
            max = Integer.max(max, j - i);
        }

        return max;
    }
}
