/*
 * Copyright [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * We have a map of time span, represented by a int array like [1, 3] and value if the watch number in this array. Find
 * out maximum watches number in any of the time.
 *
 *
 *
 */
public class MaxWatches {
    static class TimeWatch {
        int start;

        int end;

        int watches;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWatches() {
            return watches;
        }
    }

    public static TimeWatch getTimeWatch(int start, int end, int watches) {
        TimeWatch tw = new TimeWatch();
        tw.start = start;
        tw.end = end;
        tw.watches = watches;

        return tw;
    }

    /**
     *
     * This one calculates max watches at any time, which means any of time, we only care about one time span.
     *
     * MyCalendar: Sort the array based on the entry time. use a binary heap to stored current max wataches, every time we
     * enter a time frame, we add it to binary heap, when exits a time frame, we pop the frame. Try to catch max watches
     * at any time.
     *
     * @param timeWatches
     * @return
     */
    public static int maxWatches(TimeWatch[] timeWatches) {
        Arrays.sort(timeWatches, Comparator.comparing(TimeWatch::getStart));

        PriorityQueue<TimeWatch> bh = new PriorityQueue<>(Comparator.comparing(TimeWatch::getWatches));

        return 0;

    }

    /**
     * This one calculates total max watches at any time, which means in any of time, we calculate total watches, also
     * in the boundary, if one is in, one is out, we calculate the max watches of this two.
     *
     * @param timeWatches
     * @return
     */
    public static int maxTotalWatches(TimeWatch[] timeWatches) {
        return 0;
    }
}
