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

package com.haibo.yan.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * see https://leetcode.com/problems/minimum-time-difference
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any
 * two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 *
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2)
            return 0;

        List<int[]> times = new ArrayList<>();
        for (String point : timePoints) {
            String[] time = point.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            times.add(new int[]{hour, minute});
        }

        Collections.sort(times, Comparator.comparing((int[] a) -> a[0]).thenComparing((int[] b) -> b[1]));

        int minDifference = Integer.MAX_VALUE;


        for (int j = 1; j < times.size(); j++) {
            int[] t1 = times.get(j - 1), t2 = times.get(j);

            minDifference = Math.min(minDifference, (t2[0] - t1[0]) * 60 + t2[1] - t1[1]);
        }

        int[] t0 = times.get(0), te = times.get(times.size() - 1);

        minDifference = Math.min(minDifference, (t0[0] - te[0]) * 60 + t0[1] - te[1] + 24 * 60);
        return minDifference;
    }
}
