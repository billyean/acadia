package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] in = new int[n];
        int[] out = new int[n];
        int[] r = new int[n];
        for (int[] booking : bookings) {
            in[booking[0] - 1] += booking[2];
            out[booking[1] - 1] -= booking[2];
        }

        int c = 0;
        for (int i = 0 ; i < n; i++) {
            r[i] = c + in[i];
            c = r[i] + out[i];
        }

        return r;
    }
}
