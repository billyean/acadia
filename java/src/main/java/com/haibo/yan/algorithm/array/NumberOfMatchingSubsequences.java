package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;

        HashMap<Character, List<String>> ca = new HashMap<>();
        for (String word : words) {
            char c = word.charAt(0);
            String suffix = word.substring(1);
            List<String> suffices = ca.getOrDefault(c, new ArrayList<>());
            suffices.add(suffix);
            ca.put(c, suffices);
        }

        for (int j = 0; j < S.length(); j++) {
            char c = S.charAt(j);

            if (ca.containsKey(c)) {
                List<String> suffices = ca.remove(c);
                for (String suffix : suffices) {
                    if (suffix.length() == 0) {
                        res++;
                    } else {
                        char next_c = suffix.charAt(0);
                        String next_suffix = suffix.substring(1);
                        List<String> next_suffices = ca.getOrDefault(next_c, new ArrayList<>());
                        next_suffices.add(next_suffix);
                        ca.put(next_c, next_suffices);
                    }
                }
            }
        }
        return res;
    }
}
