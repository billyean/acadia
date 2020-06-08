package com.haibo.yan.algorithm.array;

import java.util.*;

/**
 * https://leetcode.com/submissions/detail/350469140/
 */
public class RandomizedCollection {

    private Map<Integer, Set<Integer>> valueToPos = new HashMap<>();

    private Map<Integer, Integer> posToValue = new HashMap<>();

    Set<Integer> removed = new HashSet<>();

    int total = 0;

    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean existed = valueToPos.containsKey(val);
        Set<Integer> set = valueToPos.getOrDefault(val, new HashSet<>());
        int p = removed.isEmpty() ? (++total) : removed.iterator().next();
        removed.remove(p);
        set.add(p);
        valueToPos.put(val, set);
        posToValue.put(p, val);
        return !existed;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        boolean existed = valueToPos.containsKey(val);
        if (existed) {
            Set<Integer> pos = valueToPos.get(val);
            int p = pos.iterator().next();
            pos.remove(p);
            if (pos.size() == 0) {
                valueToPos.remove(val);
            }
            posToValue.remove(p);
            removed.add(p);
        }

        return existed;

    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int c = total - removed.size();
        int v = rand.nextInt(c);
        int p = (Integer) (new ArrayList(posToValue.keySet()).get(v));
        return posToValue.get(p);
    }

}
