package com.haibo.yan.algorithm.datastructure;

/**
 * https://leetcode.com/problems/iterator-for-combination/submissions/
 */
public class CombinationIterator {
    private int[] p;

    private String characters;

    private boolean n;

    public CombinationIterator(String characters, int combinationLength) {
        p = new int[combinationLength];
        for (int i = 0; i < combinationLength; i++) {
            p[i] = i;
        }
        this.characters = characters;
        n = combinationLength <= characters.length();
    }

    public String next() {
        char[] rc = new char[p.length];
        for (int i = 0; i < p.length; i++) {
            rc[i] = characters.charAt(p[i]);
        }
        ascend();
        return String.valueOf(rc);
    }

    private void ascend() {
        int index = p.length - 1;
        if (p[index] < characters.length() - 1) {
            p[index]++;
        } else {
            while(index > 0 && p[index - 1] == p[index] - 1) {
                index--;
            }

            if (index == 0) {
                n = false;
            } else {
                p[index - 1]++;
                for (int i = index; i < p.length; i++) {
                    p[i] = p[i - 1] + 1;
                }
            }
        }
    }

    public boolean hasNext() {
        return n;
    }
}
