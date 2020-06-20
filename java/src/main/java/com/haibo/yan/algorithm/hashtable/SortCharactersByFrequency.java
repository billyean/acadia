package com.haibo.yan.algorithm.hashtable;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character , Integer> cf = new HashMap<>();

        for (char c : s.toCharArray()) {
            cf.put(c, cf.getOrDefault(c, 0) + 1);
        }

        List<Character> cl = new ArrayList<>(cf.keySet());
        Collections.sort(cl, Comparator.comparing(v -> cf.get(v)));

        StringBuilder b = new StringBuilder();

        for (int i = cl.size() - 1; i >= 0; i--) {
            char c = cl.get(i);
            int n = cf.get(c);
            for (int j = 0; j < n; j++) {
                b.append(c);
            }
        }

        return b.toString();
    }
}
