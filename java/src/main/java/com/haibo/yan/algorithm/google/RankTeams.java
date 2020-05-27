package com.haibo.yan.algorithm.google;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/submissions/
 */
public class RankTeams {
    public String rankTeams(String[] votes) {
        int len = Arrays.stream(votes).mapToInt(String::length).max().getAsInt();
        HashMap<String, int[]> cv = new HashMap<>();

        for (String vote : votes) {
            char[] cs = vote.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                String c = String.valueOf(cs[i]);
                int[] p = cv.getOrDefault(c, new int[len]);
                p[i]++;
                cv.put(c, p);
            }
        }

        List<String> cs = cv.keySet().stream().collect(Collectors.toList());
        Collections.sort(cs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int[] v1 = cv.get(o1);
                int[] v2 = cv.get(o2);
                for (int i = 0;  i < len; i++) {
                    if(v1[i] > v2[i]) {
                        return -1;
                    } else if(v1[i] < v2[i]) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        return cs.stream().collect(Collectors.joining(""));
    }
}
