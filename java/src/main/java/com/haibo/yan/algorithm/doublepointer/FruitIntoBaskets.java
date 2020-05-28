package com.haibo.yan.algorithm.doublepointer;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int total = 0;
        int i = 0, j = 0;

        HashSet<Integer> v = new HashSet<>();

        while (j < tree.length) {
            if(!v.contains(tree[j])) {
                if(v.size() < 2) {
                    v.add(tree[j]);
                } else {
                    total = Integer.max(total, j - i);
                    int k = j - 1;
                    while (k > 0 && tree[k - 1] == tree[k]) {
                        k--;
                    }
                    v = new HashSet<>();
                    v.add(tree[k]);
                    v.add(tree[j]);
                    i= k;
                }
            }
            j++;
        }
        total = Integer.max(total, j - i);
        return total;
    }
}
