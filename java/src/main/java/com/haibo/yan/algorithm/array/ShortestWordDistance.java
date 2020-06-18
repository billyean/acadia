package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance {
    /**
     * https://leetcode.com/problems/shortest-word-distance-iii/
     */
    public int shortestWordDistance3(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> wi = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            List<Integer> idx = wi.getOrDefault(w, new ArrayList<>());
            idx.add(i);
            wi.put(w, idx);
        }

        int min = words.length;

        if (word1.equals(word2)) {
            List<Integer> idx = wi.get(word1);
            for (int i = 1; i < idx.size(); i++) {
                min = Integer.min(idx.get(i) - idx.get(i - 1), min);
            }
        } else {
            List<Integer> idx1 = wi.get(word1);
            List<Integer> idx2 = wi.get(word2);

            int i = 0, j = 0;

            while (i < idx1.size() && j < idx2.size()) {
                int x = Math.abs(idx1.get(i) - idx2.get(j));
                min = Integer.min(min, x);

                int x1 = words.length, x2 = words.length, x3 = words.length;
                if (i < idx1.size() - 1) {
                    x1 = Math.abs(idx2.get(j) - idx1.get(i + 1));
                }
                if (j < idx2.size() - 1) {
                    x2 = Math.abs(idx2.get(j + 1) - idx1.get(i));
                }
                if (i < idx1.size() - 1 && j < idx2.size() - 1) {
                    x3 = Math.abs(idx2.get(j + 1) - idx1.get(i + 1));
                }
                int xm = Integer.min(x1, Integer.min(x2, x3));
                if (xm == x1) {
                    i++;
                } else if (xm == x2) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }

        return min;
    }
}
