package com.haibo.yan.algorithm.hashtable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-string-chain/
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));
        HashMap<String, Integer> lm = new HashMap<>();
        int[] maxL = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lm.put(words[i], i);
            maxL[i] = 1;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                String pw = "";
                if (j > 0) {
                    pw += word.substring(0,j);
                }
                if (j < word.length() - 1) {
                    pw += word.substring(j + 1, word.length());
                }
                if (lm.containsKey(pw)) {
                    maxL[i] = Integer.max(maxL[i], maxL[lm.get(pw)] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            max = Integer.max(max, maxL[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestStringChain().longestStrChain(new String[]{"ksqvsyq","ks","kss",
                "czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq",
                "grukkmj","grukj","zczpzfvdhx","gru"}));
    }
}
