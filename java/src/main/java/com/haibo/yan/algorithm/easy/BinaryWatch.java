package com.haibo.yan.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the
 * minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
 *
 * see {@link https://leetcode.com/problems/binary-watch/description/}
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
