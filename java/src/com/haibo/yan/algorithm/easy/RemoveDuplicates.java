package com.haibo.yan.algorithm.easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int newLen = 0;

        if (nums.length > 0) {
            int pos = 0;
            int current = nums[pos++];
            newLen = 1;

            while (pos < nums.length) {
                if (nums[pos] != current) {
                    nums[newLen++] = nums[pos];
                    current = nums[pos];
                }
                pos++;
            }
        }
        return newLen;
    }

    public static void main(String[] args) {
        int[] testData = new int[]{1 , 1, 1, 2, 3, 3, 4, 4, 4, 4, 4 , 4, 5};

        int noDupLen = new RemoveDuplicates().removeDuplicates(testData);

        System.out.println("New len = " + noDupLen);

        for (int i = 0; i < noDupLen; i++) {
            System.out.println(String.format("data[%d] = %d", i, testData[i]));
        }
    }

}
