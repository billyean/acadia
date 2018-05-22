package com.haibo.yan.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomColor {
    double randomBt0And1() {
        return new Random(System.nanoTime()).nextDouble();
    }

    // Return empty string when colors size is 0
    public String randomColor(List<String> colors) {
        if (colors == null || colors.size() == 0) {
            return "";
        }

        HashMap<String, Long> colorsNumber = new HashMap<>();

        for (String color : colors) {
            colorsNumber.put(color, colorsNumber.getOrDefault(color, 0L) + 1L);
        }

        List<Long> distribution = new ArrayList<>();
        List<String> colorStrs = new ArrayList<>();
        long total = 0l;
        for (Map.Entry<String, Long> e :colorsNumber.entrySet() ) {
            String color = e.getKey();
            long n = e.getValue();
            total += n;
            distribution.add(n);
            colorStrs.add(color);
        }

        List<Double> distrPrecentage = new ArrayList<>();
        double d = 0;
        int c = 0;
        do {
            distrPrecentage.add(d);
            d += (double)distribution.get(c) /  total;
        } while(++c < distribution.size());

        int i = findIndex(distrPrecentage, randomBt0And1());
        return colorStrs.get(i);
    }

    private int findIndex(List<Double> percentages, double target) {
        return binrarySearch(percentages, target, 0, percentages.size());
    }

    // 0.5 1.0
    // 0.1
    // Assumption in the boundary it returns previous one instead of next one
    private int binrarySearch(List<Double> percentages, double target, int start, int end) {
        if (start + 1 == end) {
            return start;
        }
        int m = (start + end) >> 1;

        if (percentages.get(m) < target) {
            return binrarySearch(percentages, target, m, end);
        } else if (percentages.get(m) > target) {
            return binrarySearch(percentages, target, start, m);
        } else {
            return m;
        }

    }
}
