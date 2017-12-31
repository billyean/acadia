/*
 *
 *  * Copyright [2017] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.datastructure;

import com.haibo.yan.algorithm.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @see https://leetcode.com/problems/range-module
 * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following
 * interfaces in an efficient manner.
 *
 * addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval.
 * Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval
 * [left, right) that are not already tracked.
 * queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is
 * currently being tracked.
 * removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval
 * [left, right).
 * Example 1:
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
 * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
 */
public class RangeModule {
    private final TreeSet<Interval> tree;

    public RangeModule() {
        tree = new TreeSet<Interval>(Comparator.comparing(Interval::endToStart));
    }

    public void addRange(int left, int right) {
        Iterator<Interval> i = tree.tailSet(new Interval(0, left - 1)).iterator();

        int ns = left, ne = right;
        while(i.hasNext()) {
            Interval n = i.next();
            if (ne < n.start) {
                break;
            }
            ns = Math.min(n.start, ns);
            ne = Math.max(n.end, ne);
            i.remove();
        }
        tree.add(new Interval(ns, ne));
    }

    public boolean queryRange(int left, int right) {
        Interval higher = tree.higher(new Interval(0, left));
        return higher != null && higher.start <= left && higher.end >= right;
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> i = tree.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> newIntervals = new ArrayList();
        while(i.hasNext()) {
            Interval n = i.next();
            if (right < n.start) {
                break;
            }

            if (n.start < left) {
                newIntervals.add(new Interval(n.start, left));
            }

            if (right < n.end) {
                newIntervals.add(new Interval(right, n.end));
            }
            i.remove();
        }

        for (Interval interval: newIntervals) {
            tree.add(interval);
        }
    }
}
