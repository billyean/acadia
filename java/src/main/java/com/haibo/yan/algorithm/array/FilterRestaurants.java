package com.haibo.yan.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 */
public class FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Predicate<int[]> p = v -> (veganFriendly == 0 || v[2] == 1) && v[3] <= maxPrice && v[4] <= maxDistance;
        Comparator<int[]> c = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]) {
                    return -Integer.compare(a[0], b[0]);
                } else {
                    return -Integer.compare(a[1], b[1]);
                }
            }
        };
        return Arrays.stream(restaurants).filter(p).sorted(c).map(r -> r[0]).collect(Collectors.toList());
    }
}
