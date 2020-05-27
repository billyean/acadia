package com.haibo.yan.algorithm.string;

import java.util.*;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/submissions/
 */
public class StringMatching {
    public List<String> stringMatching(String[] words) {
        HashMap<Integer, Set<String>> lenList = new HashMap<>();
        for (String word : words) {
            int l = word.length();
            Set<String> wl = lenList.getOrDefault(l, new HashSet<>());
            wl.add(word);
            lenList.putIfAbsent(l, wl);
        }
        List<Integer> keys = new ArrayList<>(lenList.keySet());
        keys.sort(Comparator.comparing(Integer::intValue).reversed());

        Set<String> result = new HashSet<>();
        Set<String> allWords = new HashSet<>();
        for (int i = 0; i  < keys.size() - 1; i++) {
            int key = keys.get(i);
            int keyplus1 = keys.get(i + 1);
            Set<String> lowerSet = lenList.get(keyplus1);

            allWords.addAll(lenList.get(key));

            for (String word: allWords) {
                int s = 0;
                while (s + keyplus1 <= word.length()) {
                    String sub = word.substring(s, s + keyplus1);
                    if (lowerSet.contains(sub)) {
                        result.add(sub);
                    }
                    s++;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(new StringMatching().stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
    }
}
