package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/grumpy-bookstore-owner/
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        int x = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                x += customers[i];
            } else {
                sum += customers[i];
            }
        }
        int m = x;

        for (int i = X; i < customers.length; i++) {
            if (grumpy[i - X] == 1)
                x -= customers[i - X];
            if (grumpy[i] == 1) {
                x += customers[i];
                m = Integer.max(m , x);
            } else {
                sum += customers[i];
            }
        }

        return sum + m;
    }
}
