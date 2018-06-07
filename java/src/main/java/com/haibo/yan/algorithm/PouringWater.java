package com.haibo.yan.algorithm;

public class PouringWater {
    public int getMinBottles(int N, int K) {
        int total = 0;
        while (ones(N) > K) {
            int v = N & (-N);
            total += v;
            N += v;
        }

        return total;
    }

    private int ones(int n) {
        int ones = 0;
        int h = n;
        while (h != 0) {
            if ((h & 0x01) == 0x01) {
                ones++;
            }
            h >>= 1;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(new PouringWater().getMinBottles(13, 2));
    }
}
