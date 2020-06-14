package com.haibo.yan.algorithm.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 */
public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        if (sum <= target) {
            return arr[arr.length - 1];
        } else if (arr[0] * arr.length > target) {
            int a = target / arr.length;
            if (Math.abs(target - (a + 1) *  arr.length) < Math.abs(target - a *  arr.length)) {
                a++;
            }
            return a;
        }

        int v = target / arr.length;

        int x = Arrays.binarySearch(arr, v);
        if (x < 0) {
            x = -x -1;
        }

        sum = Arrays.stream(arr, 0, x).sum();
        while (sum + arr[x] * (arr.length - x)  < target) {
            sum += arr[x++];
        }
        int bl = arr.length - x;
        int a = (target - sum) / bl;
        if  (Math.abs(target - (a + 1) * bl - sum) < Math.abs(target - a * bl - sum)) {
            a++;
        }
        return a;
    }
}
