package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class EqualXOR {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prexor = new int[n];

        prexor[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prexor[i] = prexor[i - 1] ^ arr[i];
        }

        int sum = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = i == 0 ? prexor[j] : (prexor[j] ^ prexor[i - 1]);
                int l = j - i;

                sum += x == 0 ? l  : 0;
            }
        }

        if (n > 1)
            sum += arr[n - 1] == arr[n - 2] ? 1 : 0;

        return sum;
    }
}
