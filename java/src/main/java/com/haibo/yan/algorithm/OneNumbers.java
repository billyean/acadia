package com.haibo.yan.algorithm;

public class OneNumbers {
    /**
     * Fenwick tree solution for count one number in binaries representation
     *
     * @param i an integer to calculate one's number.
     * @return numbers of one in integer i's binary representation.
     */
    public static int countDigits(int i) {
        int count = 0;

        while (i != 0) {
            int lsb = -i & i;
            if (i < 0)
                lsb = -lsb;
            count++;
            i -= lsb;
        }

        return count;
    }
}
