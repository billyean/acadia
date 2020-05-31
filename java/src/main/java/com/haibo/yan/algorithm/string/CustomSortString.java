package com.haibo.yan.algorithm.string;

import java.util.*;

/**
 * https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            hm.put(S.charAt(i), i);
        }

        HashMap<Character, int[]> si = new HashMap<>();
        List<Character> se = new ArrayList<>();

        for (char c : T.toCharArray() ) {
            if (hm.containsKey(c)) {
                int i = hm.get(c);
                int[] pc = si.getOrDefault(c, new int[2]);
                pc[0] = i;
                pc[1]++;
                si.put(c, pc);
            } else {
                se.add(c);
            }
        }

        List<Character> keys = new ArrayList<>(si.keySet());
        Collections.sort(keys, (c1, c2) -> {
            int[] i1 = si.get(c1);
            int[] i2 = si.get(c2);
            return Integer.compare(i1[0], i2[0]);
        });

        StringBuilder s = new StringBuilder();
        for (char c : keys) {
            s.append(String.valueOf(c).repeat(Math.max(0, si.get(c)[1])));
        }
        for (char c : se) {
            s.append(c);
        }

        return s.toString();
    }
}
