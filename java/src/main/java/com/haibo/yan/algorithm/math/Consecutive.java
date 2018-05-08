package com.haibo.yan.algorithm.math;

public class Consecutive {
    static int consecutive(long num) {
        /*
         * Write your code here.
         */
        if (num <= 2) {
            return 0;
        } else if (num == 3) {
            return 1;
        }

        int u = (int)Math.sqrt(num);

        int c = 0;

        int l = 2;

        while (l <= u) {
            if ((l & 0x01) == 0) {
                if (l == 2 && num % 2 == 1) {
                    c++;
                }
                if (num % l == 0 && num / l % 2 == 1) {
                    c++;
                }
            } else {
                if (num % l == 0) {
                    c++;
                    if (((num / l) & 0x01) == 1) {
                        c++;
                    }
                }
            }

            l++;
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(-1 % 4);
    }
}
