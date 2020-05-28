package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();

        int start = 0;
        int end = cs.length - 1;
        while(start < end) {
            while(start < end && !Character.isAlphabetic(cs[start])) {
                start++;
            }
            while(start < end && !Character.isAlphabetic(cs[end])) {
                end--;
            }
            if (start != end) {
                char c = cs[start];
                cs[start] = cs[end];
                cs[end] = c;
            }
            start++;
            end--;
        }

        return String.valueOf(cs);
    }
}
