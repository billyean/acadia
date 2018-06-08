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
        boolean leftNotReach = true;
        boolean rightNotReach = true;

        if (pos < 0 && pos >= array.length) return;

        int n = array.length;

        int t = 0;

        while (t < waterAmount && (leftNotReach || rightNotReach)) {
            boolean tryLeft = false;
            if (rightNotReach) {
                int right = fillOneBottom(array, pos, false);
                if (right == array.length - 1 || array[right] == array[pos]) {
                    if (right == array.length - 1) {
                        rightNotReach = false;
                    }
                    tryLeft = true;
                } else {
                    array[right]++;
                    t++;
                }
            }

            boolean tryRight = false;
            if (tryLeft && leftNotReach) {
                int left = fillOneBottom(array, pos, true);
                if (left == 0 || array[left] == array[pos]) {
                    if (left == 0) {
                        leftNotReach = false;
                    }
                    tryRight = true;
                } else {
                    array[left]++;
                    t++;
                }
            }

            if (tryRight && tryLeft) {
                if (leftNotReach && rightNotReach) {
                    array[pos]++;
                    t++;
                } else {
                    leftNotReach = false;
                    rightNotReach = false;
                }
            }
        }
    }

    private int fillOneBottom(int[] array, int pos, boolean isLeft) {
        int c = array[pos];
        int n = pos;
        if (isLeft) {
            while (n - 1 >= 0 && array[n - 1] <= c) {
                n--;
                c = Math.min(array[n], c);
            }
            while (n > 0 && n < pos && array[n] == array[n + 1]) {
                n++;
            }
            return n;
        } else {
            while (n + 1 < array.length && array[n + 1] <= c) {
                n++;
                c = Math.min(array[n], c);
            }
            while (n < array.length - 1 && n > pos && array[n] == array[n - 1]) {
                n--;
            }
            return n;
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
        new WaterPouring().printBar(bars3, filled3);

        System.out.println("Testing 4....");
        int[] bars4 = new int[]{5, 4, 2, 2, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled4 = new int[bars1.length];
        System.arraycopy(bars4, 0, filled4, 0, filled4.length);
        new WaterPouring().pouringPositions(filled4, 8, 3);
        new WaterPouring().printBar(bars4, filled4);

        System.out.println("Testing 5....");
        int[] bars5 = new int[]{5, 4, 2, 2, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled5 = new int[bars1.length];
        System.arraycopy(bars5, 0, filled5, 0, filled5.length);
        new WaterPouring().pouringPositions(filled5, 11, 3);
        new WaterPouring().printBar(bars5, filled5);

        System.out.println("Testing 6....");
        int[] bars6 = new int[]{5, 4, 2, 2, 2, 3, 2, 1, 0, 1, 2, 4};
        int[] filled6 = new int[bars6.length];
        System.arraycopy(bars6, 0, filled6, 0, filled6.length);
        new WaterPouring().pouringPositions(filled6, 12, 3);
        new WaterPouring().printBar(bars6, filled6);

        System.out.println("Testing 7....");
        int[] bars7 = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4};
        int[] filled7 = new int[bars7.length];
        System.arraycopy(bars7, 0, filled7, 0, filled7.length);
        new WaterPouring().pouringPositions(filled7, 12, 3);
        new WaterPouring().printBar(bars7, filled7);

        System.out.println("Testing 8....");
        int[] bars8 = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] filled8 = new int[bars8.length];
        System.arraycopy(bars8, 0, filled8, 0, filled8.length);
        new WaterPouring().pouringPositions(filled8, 12, 3);
        new WaterPouring().printBar(bars8, filled8);

        System.out.println("Testing 9....");
        int[] bars9 = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4};
        int[] filled9 = new int[bars9.length];
        System.arraycopy(bars9, 0, filled9, 0, filled9.length);
        new WaterPouring().pouringPositions(filled9, 2, 3);
        new WaterPouring().printBar(bars9, filled9);
    }
}
