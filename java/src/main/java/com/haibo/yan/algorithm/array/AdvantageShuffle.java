package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/advantage-shuffle/
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        List<int[]> bs = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            bs.add(new int[]{i, B[i]});
        }
        Collections.sort(bs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (Integer.compare(o1[1], o2[1]) == 0) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        boolean[] visited = new boolean[A.length];
        int[] result = new int[A.length];
        int i = 0;
        while (i < bs.size()) {
            int[] b = bs.get(i);
            int k = -1;
            for (int j = 0; j < A.length; j++) {
                if (!visited[j] && A[j] > b[1]) {
                    if (k == -1 || A[j] < A[k]) {
                        k = j;
                    }
                }
            }
            if (k != -1) {
                visited[k] = true;
                result[b[0]] = A[k];
            } else {
                break;
            }
            i++;
        }
        int j = 0;
        while (i < bs.size()) {
            int p = bs.get(i)[0];
            while(visited[j]) {
                j++;
            }
            result[p] = A[j];
            visited[j] = true;
            i++;
        }

        return result;
    }
}
