package com.haibo.yan.algorithm.array;

public class RotateArray {
    public  void rotateRight(int[] array, int k) {
        if (array.length == 0) return;

        int rk = k % array.length;

        reverse(array, 0, array.length - 1 - rk);
        reverse(array, array.length - rk, array.length - 1);
        reverse(array, 0, array.length - 1);
    }

    private void reverse(int[] array, int start, int end) {
        if (start + 1 >= end) {
            return;
        }

        int middle = (start + end) / 2;

        for (int i = start; i <= middle; i++) {
            int t = array[i];
            array[i] = array[end + start - i];
            array[end + start - i] = t;
        }
    }
}
