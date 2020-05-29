package com.haibo.yan.algorithm.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/super-palindromes/
 */
public class SuperPalindromes {
    private boolean lessOrEqual(String a, String b) {
        if (a.length() < b.length()) {
            return true;
        }
        if (a.length() == b.length()) {
            return a.compareTo(b) <= 0;
        }
        return false;
    }

    private int superpalindromesInRange(List<String> startList, String L, String R) {
        int total = 0;
        boolean findEnd = false;
        List<String> next;
        reachEnd:
        while (!findEnd) {
            next = new ArrayList<>();
            int ol = startList.size();
            for (int i = 0; i < ol; i++) {
                String xs = startList.get(i);
                long x = Long.parseLong(xs);
                if (x != 0) {
                    String sqx = String.valueOf(x * x);
                    if (lessOrEqual(L, sqx) && lessOrEqual(sqx, R)) {
                        if (isPalindrome(sqx)) {
                            total++;
                        }
                    } else if (!lessOrEqual(sqx, R)) {
                        findEnd = true;
                        break reachEnd;
                    }

                }
                for (char c = '0'; c <= '9'; c++) {
                    String s = String.valueOf(c);
                    next.add(s + xs + s);
                }
            }
            Collections.sort(next);
            startList = next;
        }

        return total;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (cs[i] != cs[s.length() - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int superpalindromesInRange(String L, String R) {
        List<String> odd= new ArrayList<>();
        List<String> even= new ArrayList<>();
        for (char c = '0'; c <= '9'; c++) {
            String x = String.valueOf(c);
            odd.add(x);
            even.add(x + x);
        }

        return superpalindromesInRange(odd, L, R) + superpalindromesInRange(even, L, R);
    }
}
