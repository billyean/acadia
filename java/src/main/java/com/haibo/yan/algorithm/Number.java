package com.haibo.yan.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * see https://leetcode.com/problems/string-to-integer-atoi
 *
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 */
public class Number {
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;

        char[] cs = str.trim().toCharArray();

        if (cs.length == 1) {
            if (cs[0] < '0' || cs[0] > '9')
                return 0;
            return cs[0] - '0';
        }

        boolean sign = true;
        int ds = cs[0] == '+' || cs[0] == '-' ? 1 : 0;

        if (ds == 1) {
           if (cs[0] == '-')
               sign = false;
        }

        long atoiValue = 0;

        for (int i = ds; i < cs.length; i++) {
            if (cs[i] < '0' || cs[i] > '9')
                break;
            int v = cs[i] - '0';
            atoiValue = atoiValue * 10 + v;

            if (sign) {
                if (atoiValue > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            } else {
                if (-atoiValue < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
        }
        if (sign) {
            return (int)(atoiValue);
        } else {
            return (int)(-atoiValue);
        }
    }
}
