package com.haibo.yan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.haibo.yan.algorithm.Utilities.reverse;
import static com.haibo.yan.algorithm.Utilities.swap;
import static java.util.stream.Collectors.joining;

public class Permutation {
    /**
     * Insertion solution, insert next element to existed permutation
     * @param array
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> insertPermutateNoDup(T[] array) {
        List<List<T>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        for (int i = 0; i < array.length; i++) {
            T t = array[i];

            List<List<T>> next = new ArrayList<>();
            for (List<T> l : list) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, t);
                    next.add(new ArrayList<>(l));
                    l.remove(j);
                }
            }
            list = new ArrayList<>(next);
        }

        return list;
    }

    /**
     * Recusive to call permutation for next index until index reaches the end of array, add to permutation list.
     * Swap before and swap after for maintain the same order.
     * @param array
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> recursivePermutateNoDup(T[] array) {
        List<List<T>> list = new ArrayList<>();

        recursivePermutateNoDup(array, 0, list);
        return list;
    }

    public static <T> void recursivePermutateNoDup(T[] array, int start, List<List<T>> cache) {
        if (start >= array.length) {
            cache.add(new ArrayList<>(Arrays.asList(array)));
        }

        for (int i = start; i < array.length; i++) {
            swap(array, start, i);
            recursivePermutateNoDup(array, start + 1, cache);
            swap(array, start, i);
        }
    }

    /**
     * Below algorithm works for array has duplicate elements.
     *
     * The algorithm is working as following:
     * 1. Find not ascendant(note it's not descendant) start from end of array, set i as previous index of descendant start.
     * 2. Set j as index of next greater than element in array start from end.
     * 3. Swap element between i and j.
     * 4. Reverse array start from i.
     *
     */
    public static <T extends Comparable> List<List<T>> permuteDup(T[] array) {
        Arrays.sort(array);
        List<List<T>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(array)));

        int count = 0;
        int i = array.length - 1;
        while (!isReversed(array)) {
            i = array.length - 1;
            while (i > 0 && array[i].compareTo(array[i - 1]) <= 0) {
                i--;
            }

            if (i > 0) {
                i--;
            }

            int j = array.length - 1;
            while (array[j].compareTo(array[i]) <= 0) {
                j--;
            }
            swap(array, i, j);
            reverse(array, i + 1, array.length - 1);
            list.add(new ArrayList<>(Arrays.asList(array)));

            if (++count > 10) {
                break;
            }
        }
        return list;
    }

    private static <T extends Comparable> boolean isReversed(T[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            if (array[i].compareTo(array[i - 1]) > 0) {
                return false;
            }
        }

        return true;
    }
}
