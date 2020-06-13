package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/
 */
public class QueriesPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        int[] a = new int[m];
        for (int i = 1; i <=m; i++) {
            a[i-1] = i;
        }
        int[] r = new int[queries.length];

        for (int i = 0; i <queries.length; i++) {
            int q = queries[i];
            int k = 0;
            while (a[k] != q) {
                k++;
            }
            r[i] = k;
            int s = a[k];
            for (int j = k; j > 0; j--) {
                a[j] = a[j-1];
            }
            a[0] = s;
        }
        return r;
    }
}
