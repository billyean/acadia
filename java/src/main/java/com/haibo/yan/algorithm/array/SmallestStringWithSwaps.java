package com.haibo.yan.algorithm.array;

import java.util.*;

/**
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Set<String> visited = new HashSet<>();
        visited.add(s);

        Queue<String> q = new LinkedList<>();
        q.add(s);

        String r = s;

        while (!q.isEmpty()) {
            char[] cs = q.poll().toCharArray();
            for (List<Integer> pair : pairs) {
                int i = pair.get(0);
                int j = pair.get(1);
                if (i == j) {
                    continue;
                }
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
                String ns = String.valueOf(cs);
                if (!visited.contains(ns)) {
                    q.add(ns);
                    visited.add(ns);
                    if (s.compareTo(r) < 0) {
                        r = s;
                    }
                }
                cs[j] = cs[i];
                cs[i] = t;
            }
        }
        

        return r;
    }

    public static void main(String[] args) {
        List<List<Integer>> pairs = Arrays.asList(
            Arrays.asList(8,6),
            Arrays.asList(3,4),
            Arrays.asList(5,2),
            Arrays.asList(5,5),
            Arrays.asList(3,5),
            Arrays.asList(7,10),
            Arrays.asList(6,0),
            Arrays.asList(10,0),
            Arrays.asList(7,1),
            Arrays.asList(4,8),
            Arrays.asList(6,2)
        );
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("vbjjxgdfnru", pairs));
    }
}
