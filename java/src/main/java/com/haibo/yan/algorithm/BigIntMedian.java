package com.haibo.yan.algorithm;

import java.util.List;

public class BigIntMedian {
    private static final int CHUNK_SIZE = 1 << 16;

    private static final int BLOCK_SIZE = 1 << 16;

    public int median(List<Integer> bigChunk) {
        long[] array = new long[CHUNK_SIZE];

        int h = bigChunk.size() / 2;

        for (int v : bigChunk) {
            int d = (int)(((long)v - Integer.MIN_VALUE) /  BLOCK_SIZE);
            array[d]++;
        }

        int di = array.length - 1;
        long t = 0;

        for (int i = 0; i < array.length; i++) {
            if (t >= h) {
                di = i;
                break;
            }
            t += array[i];
        }

        long k = t - h;
        System.out.println(" k = " + k);

        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        for (int v : bigChunk) {
            if (v >= di * BLOCK_SIZE + Integer.MIN_VALUE && v < (di + 1) * BLOCK_SIZE + Integer.MIN_VALUE) {
                array[(int)((long)(v - Integer.MIN_VALUE - di * BLOCK_SIZE))]++;
            }
        }

        t = 0;

        int c = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                c = di * BLOCK_SIZE + Integer.MIN_VALUE + i;
            }
            if (array[i] + t > k) {
                return di * BLOCK_SIZE + Integer.MIN_VALUE + i;
            }
        }

        return c;
    }
}
