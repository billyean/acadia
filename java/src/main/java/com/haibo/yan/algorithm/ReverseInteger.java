package com.haibo.yan.algorithm;

/**
 *
 * see https://leetcode.com/problems/reverse-integer/
 *
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x < 10 && x > -10) return x;

        long y = x;

        long i = 1;

        while ((y = y / 10) != 0) {
            i = i * 10;
        }

        y = 0;
        long xy = x;
        long j = 1;
        while (i > 0) {
            long q = xy / i;
            y = y + q * j;
            xy %= i;
            i = i / 10;
            j *= 10;
        }

        return  (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) ? 0 : (int)y;
    }

}
