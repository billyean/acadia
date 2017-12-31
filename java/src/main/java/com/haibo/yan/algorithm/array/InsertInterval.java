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

package com.haibo.yan.algorithm.array;


import com.haibo.yan.algorithm.Interval;

import java.util.*;

/**
 *
 * see https://leetcode.com/problems/insert-interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>(intervals);

        Comparator<Interval> comp = Comparator.comparing((Interval i) -> i.start).
                thenComparing((Interval i) -> i.end);
        Collections.sort(result, comp);
        int[] starts = result.stream().mapToInt(i -> i.start).toArray();

        int iStart = Arrays.binarySearch(starts, newInterval.start);
        int iEnd = Arrays.binarySearch(starts, newInterval.end);

        int is = iStart < 0 ? -iStart - 1 : iStart;
        int ie = iEnd   < 0 ? -iEnd - 1 : iEnd;

        if (is == ie && iStart >= 0 && iEnd >= 0) {
            return intervals;
        }


        while (is > 0 && result.get(is - 1).end >= newInterval.start) {
            is--;
        }

        while (ie < result.size() && result.get(ie).start <= newInterval.end) {
            ie++;
        }

        int s, e;

        if (is == ie) {
            s = newInterval.start;
            e = newInterval.end;
        } else {
            s = Math.min(result.get(is).start, newInterval.start);
            e = Math.max(newInterval.end, result.get(ie - 1).end);
        }

        for (int i = ie - 1; i >= is; i--) {
            result.remove(i);
        }

        result.add(is, new Interval(s, e));

        return result;
    }
}
