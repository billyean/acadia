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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class MyCalendarTwo {
    private final List<Integer> starts;
    private final List<int[]> calendar;

    public MyCalendarTwo() {
        starts = new ArrayList<>();
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int[] a = new int[]{1,2};
        Arrays.sort(a);
        int i = Collections.binarySearch(starts, start);
        if (i < 0) {
            i = -i - 1;
        }
        int mj = i;
        int be = 0;
        int mx = start;
        while (mj > 0) {
            if (calendar.get(mj - 1)[1] > start) {
                if(be > 0) {
                    return false;
                }
                be++;
                mx = calendar.get(mj - 1)[1];
            }
            mj--;
        }

        int mi = i;
        while (mi < starts.size() - 1 && starts.get(mi) < end) {
            if (starts.get(mi) < mx) {
                return false;
            }
            if (starts.get(mi+1) < end) {
                return false;
            }
            mi++;
        }
        starts.add(i, start);
        calendar.add(i, new int[]{start, end});
        return true;
    }
//    public static class Range implements Comparable<Range>{
//        public int getStart() {
//            return start;
//        }
//
//        public void setStart(int start) {
//            this.start = start;
//        }
//
//        public int getEnd() {
//            return end;
//        }
//
//        public void setEnd(int end) {
//            this.end = end;
//        }
//
//        public int getTime() {
//            return time;
//        }
//
//        public void setTime(int time) {
//            this.time = time;
//        }
//
//        public Range(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        private int start;
//
//        private int end;
//
//        private int time;
//
//        @Override
//        public int compareTo(Range o) {
//            if (start < o.getStart()) {
//                return -1;
//            } else  if (start > o.getStart()) {
//                return 1;
//            }
//
//            if (end < o.getEnd()) {
//                return -1;
//            } else if (end > o.getEnd()) {
//                return 1;
//            }
//
//            return 0;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("{[%d, %d], time = %d}", start, end, time);
//        }
//    }
//
//    List<Range> ranges;
//
//
//    public MyCalendarTwo() {
//        ranges = new ArrayList<>();
//    }
//
//    public boolean book(int start, int end) {
//
//        Range r = new Range(start, end);
//
//        int i = Collections.binarySearch(ranges, r);
//        if (i >= 0) {
//            Range ir = ranges.get(i);
//            if (ir.getTime() == 2) {
//                return false;
//            } else {
//                ir.setTime(2);
//                return true;
//            }
//        } else {
//            int insert = -i - 1;
//
//            if (insert > 0) {
//                Range br = ranges.get(insert - 1);
//                if (overlap(br, r)) {
//                    if (br.getTime() == 2) {
//                        return false;
//                    }
//                }
//            }
//
//            if (insert < ranges.size()) {
//                int insertPos = insert;
//                while (insertPos < ranges.size() && ranges.get(insertPos).getStart() < r.getEnd()) {
//                    if (ranges.get(insertPos).getTime() == 2) {
//                        return false;
//                    }
//                    insertPos++;
//                }
//            }
//
//            // Merge before
//            if (insert > 0) {
//                Range br = ranges.get(insert - 1);
//                if (overlap(br, r)) {
//                    int s1 = br.getStart(), e1 = r.getStart();
//                    int s2 = e1, e2 = br.getEnd();
//                    int s3 = e2, e3 = r.getEnd();
//                    if (s1 == e1) {
//                        ranges.remove(--insert);
//                    } else {
//                        br.setEnd(e1);
//                    }
//                    Range or = new Range(s2, e2);
//                    or.setTime(2);
//                    ranges.add(insert++, or);
//                    r.setStart(s3);
//                }
//            }
//
//            // Merge after
//            if (insert < ranges.size()) {
//                Range ar = ranges.get(insert);
//                if (overlap(r, ar) ) {
//                    int s1 = r.getStart(), e1 = ar.getStart();
//                    int s2 = e1, e2 = r.getEnd();
//                    int s3 = e2, e3 = ar.getEnd();
//                    if (s1 != e1) {
//                        r.setEnd(e1);
//                        ranges.add(insert++, r);
//                    }
//
//                    Range or = new Range(s2, e2);
//                    or.setTime(2);
//                    ranges.add(insert++, or);
//                    ar.setStart(s3);
//
//                } else {
//                    r.setTime(1);
//                    ranges.add(insert, r);
//                }
//            } else {
//                r.setTime(1);
//                ranges.add(insert, r);
//            }
//
//            return true;
//        }
//    }
//
//    private boolean overlap(Range r1, Range r2) {
//        if (r1.getEnd() > r2.getStart()) {
//            return true;
//        }
//
//        return false;
//    }
//
//    public void printRange() {
//        System.out.println(ranges.stream().map(v -> v.toString()).collect(joining(":::")));
//    }

    public static void main(String[] args) {
        MyCalendarTwo cal = new MyCalendarTwo();

        System.out.println(cal.book(24, 40)); // returns true
        System.out.println(cal.book(43, 50)); // returns true
        System.out.println(cal.book(27, 43)); // returns true
        System.out.println(cal.book(5, 21)); // returns false
        System.out.println(cal.book(30, 40)); // returns true
        System.out.println(cal.book(14, 29)); // returns true
        System.out.println(cal.book(3, 19));
        System.out.println(cal.book(3, 14));
        System.out.println(cal.book(25, 39));
        System.out.println(cal.book(6, 19));


//        System.out.println(cal.book(24, 40));
//
//
//        System.out.println(cal.book(43, 50));
//
//
//        System.out.println(cal.book(27, 43));
//
//
//        System.out.println(cal.book(5, 21));
//
//
//        System.out.println(cal.book(30, 40));
//
//
//        System.out.println(cal.book(14, 29));
//
//
//        System.out.println(cal.book(3, 19));
//
//
//        System.out.println(cal.book(3, 14));
//
//
//        System.out.println(cal.book(25, 39));
//
//
//        System.out.println(cal.book(6, 19));


    }

}
