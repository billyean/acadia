package com.haibo.yan.algorithm.hashtable;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/rabbits-in-forest/
 */
public class RabbitInForest {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> colors = new HashMap<>();

        for (int answer: answers) {
            int n = colors.getOrDefault(answer, 0);
            colors.put(answer, n + 1);
        }

        int total = 0;
        for (int ck: colors.keySet()) {
            int v = colors.get(ck);
            if (v <= ck + 1) {
                total += ck + 1;
            } else {
                while (v > 0) {
                    total += ck + 1;
                    v -= ck + 1;
                }
            }
        }

        return total;
    }
}
