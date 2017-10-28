/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * See https://leetcode.com/problems/merge-intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    public boolean equals(Object o) {
        Interval other = (Interval)o;
        return start == other.start && end == other.end;
    }
}

public class MergeIntervals {


    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comparator = Comparator.<Interval, Integer>comparing(i -> i.start).thenComparing(j -> j.end);
        Collections.sort(intervals, comparator);

        List<Interval> merged = new ArrayList<>();

        int i = 0;

        while (i < intervals.size()) {
            Interval current = intervals.get(i);

            int j = i + 1;
            int newStart = current.start;
            int newEnd = current.end;

            while (j < intervals.size() && intervals.get(j).start <= newEnd) {
                newEnd = Math.max(newEnd, intervals.get(j).end);
                j++;
            }
            merged.add(new Interval(newStart, newEnd));
            i = j;
        }

        return merged;
    }
}
