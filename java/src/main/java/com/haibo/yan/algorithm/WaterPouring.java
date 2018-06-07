package com.haibo.yan.algorithm;

import java.util.Arrays;

public class WaterPouring {
    public void printBar(int[] bars, int[] filled) {
        if (bars.length == 0) {
            return;
        }

        int maxBar = Arrays.stream(bars).max().getAsInt();

        for (int i = 0; i <= maxBar; i++) {
            for (int j = 0; j < bars.length; j++) {
                if (maxBar - filled[j] > i) {
                    System.out.print(" ");
                } else if (maxBar - bars[j] > i) {
                    System.out.print("W");
                }  else {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }


    public void pouringPositions(int[] array, int waterAmount, int pos) {
        int d = 0;
        if (pos < 0 && pos >= array.length) return;

        int n = array.length;

        int[] poured = new int[array.length];

        int t = 0;

        while (t < waterAmount && d < 2) {
            int p = pos;

            if (p + 1 < n && array[p + 1] <= array[p] ) {
                while (p + 1 < n && array[p + 1] <= array[p]) {
                    p++;
                }
                if (p != n - 1) {
                    while (array[p] == array[p - 1]) {
                        p--;
                    }
                    array[p]++;
                } else {
                    d++;
                }
            } else if (p > 0 && array[p - 1] <= array[p]){
                while (p > 0 && array[p - 1] <= array[p]) {
                    while (array[p] == array[p + 1]) {
                        p++;
                    }
                    p--;
                }
                if (p != 0) {
                    array[p]++;
                } else {
                    d++;
                }
            } else {
                while (p > 0 && array[p - 1] < array[p]) {
                    p--;
                }
                if (p != 0) {
                    array[p]++;
                } else {
                    d++;
                }
                array[p]++;
            }

            if (p >= 0 && p < n) {
                t++;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Testing 1....");
        int[] bars1 = new int[]{5, 4, 2, 1, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled1 = new int[bars1.length];
        System.arraycopy(bars1, 0, filled1, 0, filled1.length);
        new WaterPouring().pouringPositions(filled1, 8, 1);
        new WaterPouring().printBar(bars1, filled1);

        System.out.println("Testing 2....");
        int[] bars2 = new int[]{5, 4, 2, 1, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled2 = new int[bars1.length];
        System.arraycopy(bars2, 0, filled2, 0, filled2.length);
        new WaterPouring().pouringPositions(filled2, 7, 1);
        new WaterPouring().printBar(bars2, filled2);

        System.out.println("Testing 3....");
        int[] bars3 = new int[]{5, 4, 2, 1, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled3 = new int[bars3.length];
        System.arraycopy(bars3, 0, filled3, 0, filled3.length);
        new WaterPouring().pouringPositions(filled3, 30, 1);
        new WaterPouring().printBar(bars1, filled3);

        System.out.println("Testing 4....");
        int[] bars4 = new int[]{5, 4, 2, 2, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled4 = new int[bars1.length];
        System.arraycopy(bars1, 0, filled4, 0, filled4.length);
        new WaterPouring().pouringPositions(filled4, 8, 3);
        new WaterPouring().printBar(bars4, filled4);

        System.out.println("Testing 5....");
        int[] bars5 = new int[]{5, 4, 2, 2, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled5 = new int[bars1.length];
        System.arraycopy(bars1, 0, filled5, 0, filled5.length);
        new WaterPouring().pouringPositions(filled5, 11, 3);
        new WaterPouring().printBar(bars5, filled5);

        System.out.println("Testing 6....");
        int[] bars6 = new int[]{5, 4, 2, 2, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled6 = new int[bars6.length];
        System.arraycopy(bars6, 0, filled6, 0, filled6.length);
        new WaterPouring().pouringPositions(filled6, 12, 3);
        new WaterPouring().printBar(bars6, filled6);
    }
}
