package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        char min = letters[0];
        int m = (min - target + 26) % 26;
        if (m == 0) m = 26;

        for (int i = 1; i < letters.length; i++) {
            int v = (letters[i] - target + 26) % 26;
            if (v == 0) v = 26;
            if (v < m) {
                m = v;
                min = letters[i];
            }
        }
        return min;
    }
}
