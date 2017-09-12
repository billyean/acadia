package com.haibo.yan.algorithm.array;

/**
 * See https://leetcode.com/problems/zigzag-conversion/description/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 */
public class Zigzag {
    /**
     * Note actually the ZigZag has span 2n - 2 - 2 * i and 2 * i, and zero span will be skipped also
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows < 2 || s.length() == 0)
            return s;

        char[] cs = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int span1 = 2 *  numRows - 2 - 2 * i;
            int span2 = 2 * i;

            int index = i;
            boolean add1 = true;

            while (index < s.length()) {
                sb.append(cs[index]);
                if (span1 == 0) {
                    index += span2;
                } else if (span2 == 0) {
                    index += span1;
                } else if (add1) {
                    index += span1;
                } else {
                    index += span2;
                }
                add1 = !add1;
            }
        }
        return sb.toString();
    }
}
