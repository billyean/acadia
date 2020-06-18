package com.haibo.yan.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> ci = new HashMap<>();
        for (char t : tasks) {
            ci.put(t, ci.getOrDefault(t, 0) + 1);
        }
        int[] v = ci.values().stream().sorted().mapToInt(Integer::intValue).toArray();
        Arrays.sort(v);

        int sum = 0;
        while (v[v.length - 1] > 0) {
            int j = v.length - 1;
            int k = n + 1;
            while (j >= 0 && k > 0) {
                if (v[j] != 0) {
                    k--;
                    v[j]--;
                    sum++;
                }
                j--;
            }
            Arrays.sort(v);
            if (v[v.length - 1] > 0 && k > 0) {
                sum += k;
            }
        }

        return sum;
    }
}
