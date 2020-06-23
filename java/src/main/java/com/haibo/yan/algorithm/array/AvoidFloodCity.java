package com.haibo.yan.algorithm.array;

import java.util.*;

/**
 * https://leetcode.com/problems/avoid-flood-in-the-city/
 */
public class AvoidFloodCity {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Queue<Integer>> m = new HashMap<>();
        int zero = 0;
        for (int i = 0; i < rains.length; i++) {
            int rain = rains[i];
            if (rain != 0) {
                Queue<Integer> occurs = m.getOrDefault(rain, new LinkedList<>());
                occurs.add(i);
                m.put(rain, occurs);
            } else {
                zero++;
            }
        }

        for(int key : m.keySet()) {
            zero -= m.get(key).size() - 1;
        }

        if (zero < 0) {
            return new int[0];
        }

        Comparator<Integer> c = Comparator.comparing(v -> m.get(v).peek());
        PriorityQueue<Integer> pq = new PriorityQueue(c);
        int[] r = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            int rain = rains[i];
            if (rain != 0) {
                if (pq.contains(rain)) {
                    return new int[0];
                } else {
                    r[i] = -1;
                    if (m.get(rain).size() > 1) {
                        Queue<Integer> l = m.get(rain);
                        l.poll();
                        pq.add(rain);
                    }
                }
            } else {
                if (pq.isEmpty()) {
                    r[i] = 1;
                } else {
                    int y = pq.iterator().next();
                    Queue<Integer> candidate = m.get(y);
                    int dry = candidate.peek();
                    r[i] = rains[dry];
                    pq.remove(y);
                }
            }
        }
        return r;
    }
}
