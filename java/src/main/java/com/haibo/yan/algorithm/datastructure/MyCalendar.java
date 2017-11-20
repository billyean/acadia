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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * see https://leetcode.com/problems/my-calendar-i
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a
 * double booking.
 * Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 *  A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * Example 1:
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * Explanation:
 * The first event can be booked.  The second can't because time 15 is already booked by another event.
 * The third event can be booked, as the first event takes every time less than 20, but not including 20.
 */
public class MyCalendar {
    public MyCalendar() {
        starts = new ArrayList<>();
        ends = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int index = Collections.binarySearch(starts, start);

        if (index >= 0) {
            return false;
        } else {
            int i = - index - 1;
            if (i > 0) {
                if (start < ends.get(i - 1)) {
                    return false;
                }
            }

            if (i < starts.size()) {
                if (end > starts.get(i)) {
                    return false;
                }
            }
            starts.add(i, start);
            ends.add(i, end);
        }

        return true;
    }

    private final List<Integer> starts;

    private final List<Integer> ends;
}
