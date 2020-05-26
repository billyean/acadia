package com.haibo.yan.algorithm.math;

import java.util.Arrays;

public class MostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] D, int N) {
        Arrays.sort(D);
        char[] cs = String.valueOf(N).toCharArray();
        int len = cs.length;

        int allN = powerSum(D.length, cs.length - 1);
        int p = 0;
        do {
            String ps = String.valueOf(cs[p]);
            int s = Arrays.binarySearch(D, ps);
            if (s < 0) {
                s = -s - 1;
                allN += s * power(D.length, cs.length - p - 1);
                break;
            } else {
                allN += s * power(D.length, cs.length - p - 1);
                if (cs.length - p == 1)
                    allN++;
            }
        } while (++p < len);
        return allN;
    }

    private int powerSum(int digits, int len) {
        if (len == 0) {
            return 0;
        } else {
            int n = 0;
            int p = digits;
            int i = 1;
            do {
                n += p;
                p *= digits;
            } while (++i <= len);
            return n;
        }
    }

    private int power(int digits, int len) {
        int n = 1;
        for (int i = 0; i < len; i++) {
            n *= digits;
        }
        return n;
    }



    public static void main(String[] args) {
        System.out.println(new MostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"} ,100));
        System.out.println(new MostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"7"} ,8));
        System.out.println(new MostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "4", "9"} ,1000000000));
        System.out.println(new MostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"3", "4", "8"} ,4));
        System.out.println(new MostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"3", "4", "5", "6"} ,64));
        System.out.println(new MostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1"} ,834));
        System.out.println(new MostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "7"} ,231));
    }
}
