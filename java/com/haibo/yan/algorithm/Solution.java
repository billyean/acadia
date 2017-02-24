package com.haibo.yan.algorithm;

/**
 * Created by hyan on 2/7/17.
 */
public class Solution {
    public int maxProduct(String[] words) {
        int[] iw = new int[words.length];
        int[] lw = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            iw[i] = strPre(words[i]);
            lw[i] = words[i].length();
        }

        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((iw[i] & iw[j]) == 0) {
                    int product = lw[i] * lw[j];
                    if (product > max) {
                        System.out.println("i = " + i + "\tj = " + j);
                        max = product;
                    }
                }
            }
        }
        return max;
    }

    private int strPre(String s) {
        char[] cs = s.toCharArray();
        int r = 0;
        for (int i = 0; i < cs.length; i++) {
            r |= 1 << (cs[i] - 'a');
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
