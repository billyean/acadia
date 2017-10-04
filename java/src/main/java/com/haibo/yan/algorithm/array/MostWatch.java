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

package com.haibo.yan.algorithm.array;

import java.util.HashSet;

/**
 * Q1) When streaming videos to millions of people, it is critical for Amazon to accurately estimate the scale
 * required to handle the load. Imagine prime video telecasts live certain events throughout the day and various
 * events have different schedules (some of them may overlap with each other). For each event, there is an estimated
 * viewership (number of people estimated to watch that show). Given the complete schedule for a certain duration as
 * input, estimate the maximum total number of viewers viewing through this system, for that duration.
 * <p>
 * [((1, 5), 1000000), ((2, 10), 150000), ((10, 12), 200000), ((14, 18), x), ((7, 12), y)]
 */


public class MostWatch {
    static class RangeNumber {
        int start;
        int end;
        int count;
    }


    public static int naiveFind(RangeNumber[] ranges) {
        if (ranges == null || ranges.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (RangeNumber range : ranges) {
            set.add(range.start);
            set.add(range.end);
        }

        int[] checkPoints = set.stream().mapToInt(Integer::intValue).toArray();
        //Arrays.sort(checkPoints);

        int max = 0;

        for (int checkPoint : checkPoints) {
            int left = 0, right = 0;

            for (RangeNumber range : ranges) {
                if (checkPoint == range.start) {
                    left += range.count;
                } else if (checkPoint == range.end) {
                    right += range.count;
                } else if (checkPoint > range.start && checkPoint < range.end) {
                    left += range.count;
                    right += range.count;
                }

                int more = Integer.max(left, right);
                if (more > max) {
                    max = more;
                }
            }
        }

        return max;
    }

    public static int optimalFind(RangeNumber[] ranges) {
        if (ranges == null || ranges.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (RangeNumber range : ranges) {
            set.add(range.start);
            set.add(range.end);
        }

        int[] checkPoints = set.stream().mapToInt(Integer::intValue).toArray();
        //Arrays.sort(checkPoints);

        int max = 0;

        for (int checkPoint : checkPoints) {
            int left = 0, right = 0;

            for (RangeNumber range : ranges) {
                if (checkPoint == range.start) {
                    left += range.count;
                } else if (checkPoint == range.end) {
                    right += range.count;
                } else if (checkPoint > range.start && checkPoint < range.end) {
                    left += range.count;
                    right += range.count;
                }

                int more = Integer.max(left, right);
                if (more > max) {
                    max = more;
                }
            }
        }

        return max;
    }
}




