package com.haibo.yan.algorithm.array;

import java.util.HashMap;
import java.util.Set;

public class BulbSwitcher {
    /**
     * https://leetcode.com/problems/bulb-switcher-iii/
     * @param light
     * @return
     */
    public int numTimesAllBlue(int[] light) {
        HashMap<Integer, Integer> start = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();

        int blue = 0;
        for (int x : light) {
            int xs = x, xe = x;
            if (end.containsKey(x - 1)) {
                xs = end.get(x-1);
                end.remove(x - 1);
                start.remove(xs);
            }
            if (start.containsKey(x + 1)) {
                xe = start.get(x+1);
                start.remove(x + 1);
                end.remove(xe);
            }
            start.put(xs, xe);
            end.put(xe, xs);

            Set<Integer> keys = start.keySet();
            if(keys.size() == 1 && keys.iterator().next() == 1) {
                blue++;
            }
        }

        return blue;
    }
}
