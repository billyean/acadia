package com.haibo.yan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaterPouring {
    public void printBar(int[] bars) {
        for (int i : bars) {
            for (int j = 0; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }


    public List<List<Integer>> pouringPositions(int[] array,
                                               int waterAmount, int pos) {
        List<List<Integer>> positions = new ArrayList<>();

        int d = 0;
        if (pos < 0 && pos >= array.length) return positions;

        int n = array.length;

        int[] poured = new int[array.length];

        int t = 0;

        while (t < waterAmount && d < 2) {
            int p = pos;
            if (p + 1 < n && array[p + 1] < array[p]) {
                while (p + 1 < n && array[p + 1] < array[p]) {
                    p++;
                }
                if (p != n - 1) {
                    array[p]++;
                } else {
                    d++;
                }
            } else if (p > 0 && array[p - 1] < array[p]){
                while (p > 0 && array[p - 1] < array[p]) {
                    p--;
                }
                if (p != 0) {
                    array[p]++;
                } else {
                    d++;
                }
            } else {
                array[p]++;
            }

            if (p >= 0 && p < n) {
                positions.add(Arrays.asList(p, array[p]));
                t++;
            }

        }

        return positions;
    }

    public static void main(String[] args) {
        int[] bars = new int[]{5, 4, 2, 1, 2, 3, 2, 1, 0, 1, 2, 4};
        new WaterPouring().printBar(bars);

        for (List<Integer> ps : new WaterPouring().pouringPositions(bars, 8, 1)) {
            System.out.println(ps.get(0) + ":" + ps.get(1));
        }
    }
}
