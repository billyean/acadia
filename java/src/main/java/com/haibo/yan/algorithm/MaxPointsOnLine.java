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

package com.haibo.yan.algorithm;

import java.util.HashMap;


class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxPointsOnLine {
    public int maxPoints(Point[] points) {
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            int maxFromi = maxPoints(points, i);
            if (maxFromi > max) {
                max = maxFromi;
            }
        }

        return max;
    }

    private int maxPoints(Point[] points, int i) {
        if (i == points.length - 1) {
            return 1;
        }

        HashMap<Long, Integer> slopeNumbers = new HashMap<>();

        int samePoints = 0;

        for (int j = i + 1; j < points.length; j++) {
            int yl = points[j].y - points[i].y;
            int xl = points[j].x - points[i].x;

            if (yl < 0) {
                yl = -yl;
                xl = -xl;
            }


            long slope;

            if (xl == 0) {
                slope = Long.MIN_VALUE;
                if (yl == 0) {
                    slope = Long.MAX_VALUE;
                    samePoints++;
                }
            } else if (yl == 0) {
                slope = 0;
            } else {
                int gcd = gcd(Math.abs(yl), Math.abs(xl));
                slope = (long) (xl / gcd) << 32 | (long) (yl / gcd);
            }

            if (slope != Long.MAX_VALUE) {
                int numbers = slopeNumbers.getOrDefault(slope, 0) + 1;
                slopeNumbers.put(slope, numbers);
            }
        }

        return slopeNumbers.values().stream().mapToInt(Integer::intValue).max().orElse(0) + samePoints + 1;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }

        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}
