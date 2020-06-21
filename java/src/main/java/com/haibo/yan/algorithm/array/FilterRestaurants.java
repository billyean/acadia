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
        return Arrays.stream(restaurants).filter(v ->
                (veganFriendly == 0 || v[2] == 1) && v[3] <= maxPrice && v[4] <= maxDistance
        ).sorted(Comparator.comparing((int[] a) -> -a[1]).thenComparing((int[] a) -> -a[0])
        ).map(r -> r[0]).collect(Collectors.toList());
    }
}
