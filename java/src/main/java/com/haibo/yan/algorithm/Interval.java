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

package com.haibo.yan.algorithm;

/**
 * A range class for recording a start and end.
 */
public class Interval implements Comparable<Interval> {
    /**
     * Range's start position.
     */
    public int start;

    /**
     * Range's end position.
     */
    public int end;

    public Interval() {
        start = 0; end = 0;
    }

    public Interval(int start, int end) {
        this.start = start; this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof  Interval) {
            Interval other = (Interval) o;
            return start == other.start && end == other.end;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }

    /**
     * Default comparator is compare left side then right side. This is intuitive.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Interval o) {
        int c = Integer.compare(start, o.start);
        return c == 0 ? Integer.compare(end, o.end) : c;
    }

    public long endToStart() {
        return (long)end << 32 | start;
    }
}
