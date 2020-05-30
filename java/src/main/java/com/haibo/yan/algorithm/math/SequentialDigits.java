package com.haibo.yan.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sequential-digits/
 */
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String ls = String.valueOf(low);
        String lh = String.valueOf(high);
        int lsl = ls.length();
        int lhl = lh.length();

        int[] s = new int[]{1, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789};
        int[] s1 = new int[]{1, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111};


        List<Integer> temp = new ArrayList<>();

        for (int i = lsl; i <= lhl; i++) {
            if (i <= 9) {
                for (int j = 0; j < 10 - i; j++) {
                    int n = s[i - 1] + s1[i - 1] * j;
                    temp.add(n);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i : temp) {
            if (i >= low && i <= high) {
                result.add(i);
            }
        }

        return result;

    }
}
