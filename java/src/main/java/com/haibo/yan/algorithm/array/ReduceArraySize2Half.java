package com.haibo.yan.algorithm.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */
public class ReduceArraySize2Half {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> vsize = new HashMap<>();
        for (int a :  arr) {
            int size = vsize.getOrDefault(a, 0);
            vsize.put(a, size + 1);
        }
        List<int[]> list = vsize.entrySet().stream().map(e -> new int[]{e.getKey(), e.getValue()}).collect(toList());
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (Integer.compare(a[1], b[1]) == 0) {
                    return -Integer.compare(a[0], b[0]);
                } else {
                    return -Integer.compare(a[1], b[1]);
                }
            }
        });

        int x = 0;
        int tt = 0;
        for (int[] v : list) {
            x += 1;
            tt += v[1];
            if (tt >= arr.length / 2) {
                break;
            }
        }
        return x;
    }
}
