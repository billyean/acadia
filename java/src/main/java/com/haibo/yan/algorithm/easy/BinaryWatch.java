package com.haibo.yan.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the
 * minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
 *
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times
 * the watch could represent.
 *
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should
 * be "10:02".
 *
 * see {@link https://leetcode.com/problems/binary-watch}
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List[] h = new List[]{
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()};

        List[] m = new List[]{
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()};

        for (int i = 0; i < 60; i++) {
            int b = bi(i);
            m[b].add(i);
            if (i < 12) {
                h[b].add(i);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i <= num && i < 4; i++) {
            if (num - i  < 6)
                result.addAll(combine((List<Integer>)h[i], (List<Integer>)m[num - i]));
        }
        return result;
    }

    private List<String> combine(List<Integer> hours, List<Integer> minutes) {
        List<String> allTimes = new ArrayList<>();
        for (int h : hours) {
            for (int m : minutes) {
                String t = h + ":" + (m < 10 ? "0" + m : String.valueOf(m));
                allTimes.add(t);
            }
        }
        return allTimes;
    }

    private int bi(int v) {
        int bits = 0;
        while (v != 0) {
            if ((v & 0x01) == 0x01)
                bits++;
            v = v >> 1;
        }
        return bits;
    }
}
