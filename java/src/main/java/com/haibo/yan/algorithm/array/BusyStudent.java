package com.haibo.yan.algorithm.array;

/**
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int total = 0;
        for (int i = 0; i < Integer.min(startTime.length, endTime.length); i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i] ) {
                total++;
            }
        }
        return total;
    }
}
