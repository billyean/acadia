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

package com.haibo.yan.algorithm.math;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return true;
    }

    public boolean validHelper(int[] p1, int[] p2, int[] p3, int[] p4) {
        int x1 = p1[0], x2 = p2[0], x3 = p3[0], x4 = p4[0];
        int y1 = p1[1], y2 = p2[1], y3 = p3[1], y4 = p4[1];
        return true;
    }

    private boolean perpendicular(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0], x2 = p2[0], x3 = p3[0];
        int y1 = p1[1], y2 = p2[1], y3 = p3[1];

        if (x1 == x2) {
            return y2 == y3;
        }

        if (y1 == y2) {
            return x2 == x3;
        }

        int x21 = x2 - x1;
        int y21 = y2 - y1;
        int gcd21 = gcd(x21, y21);

        int x31 = x3 - x1;
        int y31 = y3 - y1;
        int gcd31 = gcd(x31, y31);

        return y21 / gcd21 == x31 / gcd31 && x21 / gcd21 == y31 / gcd31;
    }

    private int gcd(int i, int j) {
        int a = Math.max(i, j);
        int b = Math.min(i, j);

        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

}
