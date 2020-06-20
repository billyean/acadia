package com.haibo.yan.algorithm.string;

/**
 * https://leetcode.com/problems/push-dominoes/
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int i = 0, k = i + 1;

        while (k < cs.length) {
            while (k < cs.length && cs[k] == '.') {
                k++;
            }
            if (k < cs.length) {
                if (cs[k] == 'L'){
                    if (cs[i] == '.' || cs[i] == 'L') {
                        int j = i;
                        while (j < k) {
                            cs[j++] = 'L';
                        }
                    } else {
                        int j = 0;
                        while (j < (k - i + 1) / 2) {
                            cs[i + j] = 'R';
                            cs[k - j] = 'L';
                            j++;
                        }
                    }
                } else {
                    if (cs[i] == 'R') {
                        int j = i;
                        while (j < k) {
                            cs[j++] = 'R';
                        }
                    }
                }
            } else {
                if(cs[i] == 'R') {
                    int j = i + 1;
                    while (j < k) {
                        cs[j++] = 'R';
                    }
                }
            }
            i = k;
            k = i + 1;
        }
        return String.valueOf(cs);
    }
}
