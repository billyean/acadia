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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.LongStream;

public class MyBigInt {
    private final static int INT_BIT = 9;

    public String add(String v1, String v2) {
        boolean pv1 = true, pv2 = true;
        String uv1 = v1, uv2 = v2;

        if (v1.substring(0, 1).equals("-") || v1.substring(0, 1).equals("+")) {
            uv1 = v1.substring(1);
            pv1 = v1.substring(0, 1).equals("+");
        }

        if (v2.substring(0, 1).equals("-") || v2.substring(0, 1).equals("+")) {
            uv2 = v2.substring(1);
            pv2 = v2.substring(0, 1).equals("+");
        }

        if (pv1 ^ pv2) {
            if (pv1) {
                return minusUnassigned(uv1, uv2);
            } else {
                return minusUnassigned(uv2, uv1);
            }
        } else {
            return addUnassigned(!pv1, uv1, uv2);
        }
    }

    public String minus(String v1, String v2) {
        boolean pv1 = true, pv2 = true;
        String uv1 = v1, uv2 = v2;

        if (v1.substring(0, 1).equals("-") || v1.substring(0, 1).equals("+")) {
            uv1 = v1.substring(1);
            pv1 = v1.substring(0, 1).equals("+");
        }

        if (v2.substring(0, 1).equals("-") || v2.substring(0, 1).equals("+")) {
            uv2 = v2.substring(1);
            pv2 = v2.substring(0, 1).equals("+");
        }

        if (pv1 ^ pv2) {
            return addUnassigned(!pv1, uv1, uv2);
        } else {
            if (pv1) {
                return minusUnassigned(uv1, uv2);
            } else {
                return minusUnassigned(uv2, uv1);
            }
        }
    }

    private String addUnassigned(boolean signed, String uv1, String uv2) {
        long[] sum = add(aToL(uv1, INT_BIT), aToL(uv2, INT_BIT), INT_BIT);
        return array2String(signed, sum, INT_BIT);
    }

    private String minusUnassigned(String uv1, String uv2) {
        long[] l1 = aToL(uv1, INT_BIT), l2 = aToL(uv2, INT_BIT);
        boolean signed = greatThan(l1, l2);

        return array2String(!signed, signed ? minus(l1, l2, INT_BIT) : minus(l2, l1, INT_BIT), INT_BIT);
    }

    public String multiply(String v1, String v2) {
        boolean pv1 = true, pv2 = true;
        String uv1 = v1, uv2 = v2;

        if (v1.substring(0, 1).equals("-") || v1.substring(0, 1).equals("+")) {
            uv1 = v1.substring(1);
            pv1 = v1.substring(0, 1).equals("+");
        }

        if (v2.substring(0, 1).equals("-") || v2.substring(0, 1).equals("+")) {
            uv2 = v2.substring(1);
            pv2 = v2.substring(0, 1).equals("+");
        }

        if (uv1.equals("0") || uv2.equals("0")) {
            return "0";
        }

        long[] aToL = multiply(aToL(uv1, INT_BIT), aToL(uv2, INT_BIT), INT_BIT);

        return array2String(pv1 ^ pv2, aToL, INT_BIT);
    }

    private long[] aToL(String s, int int_bit) {
        char[] cs = s.toCharArray();

        long[] vl = new long[cs.length % int_bit == 0 ? cs.length / int_bit : cs.length / int_bit + 1];

        for (int i = cs.length; i > 0; i -= int_bit) {
            int pos = (cs.length - i) / int_bit;
            for (int j = int_bit; j > 0; j--) {
                if (i - j >= 0) {
                    vl[pos] = (vl[pos]) * 10 + (cs[i - j] - '0');
                }
            }
        }

        return vl;
    }

    private long[] multiply(long[] l1, long[] l2, int int_bit) {
        long boundary = boundary(int_bit);
        long[] product = new long[l1.length + l2.length];
        for (int i1 = 0; i1 < l1.length; i1++) {
            for (int i2 = 0; i2< l2.length; i2++) {
                product[i1 + i2] += l1[i1] * l2[i2];
                product[i1 + i2 + 1] += product[i1 + i2] / boundary;
                product[i1 + i2] %= boundary;
            }
        }

        return product;
    }

    private long[] add(long[] l1, long[] l2, int int_bit) {
        long boundary = boundary(int_bit);
        int len = Math.max(l1.length, l2.length);
        long[] sum = new long[len + 1];
        int carrier = 0;
        for (int i = 0; i < len; i++) {
            sum[i] += carrier;
            sum[i] += i < l1.length ? l1[i] : 0;
            sum[i] += i < l2.length ? l2[i] : 0;
            if (sum[i] > boundary) {
                sum[i] -= boundary;
                carrier = 1;
            } else {
                carrier = 0;
            }
        }

        sum[len] = carrier;
        return sum;
    }

    /**
     * Assume l1 is greater than l2.
     * @param l1
     * @param l2
     * @param int_bit
     * @return
     */
    private long[] minus(long[] l1, long[] l2, int int_bit) {
        long boundary = boundary(int_bit);
        long[] diff = new long[l1.length];
        int carrier = 0;
        for (int i = 0; i < l1.length; i++) {
            diff[i] -= carrier;
            diff[i] += i < l1.length ? l1[i] : 0;
            diff[i] -= i < l2.length ? l2[i] : 0;
            if (diff[i] < 0) {
               diff[i] += boundary;
               carrier = 1;
            } else {
                carrier = 0;
            }
        }
        return diff;
    }

    private boolean greatThan(long[] l1, long[] l2) {
        if (l1.length > l2.length) {
            return true;
        }

        for (int i = l1.length - 1; i >= 0; i--) {
            if (l1[i] > l2[i]) {
                return true;
            } else if (l1[i] < l2[i]) {
                return false;
            }
        }

        return false;
    }

    private long[] max(long[] l1, long[] l2) {
        return greatThan(l1, l2) ? l1 : l2;
    }

    private long[] min(long[] l1, long[] l2) {
        return greatThan(l2, l1) ? l1 : l2;
    }

    private String array2String(boolean signed, long[] array, int int_bit) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        if (signed) {
            pw.append('-');
        }

        String nextFormat = "%d";
        if (array[array.length - 1] != 0) {
            pw.printf("%d", array[array.length - 1]);
            nextFormat = "%0" + int_bit + "d";
        }

        if (array.length > 1) {
            pw.printf(nextFormat, array[array.length - 2]);
        }

        for (int i = array.length - 3; i >= 0; i--) {
            pw.printf("%0" + int_bit + "d", array[i]);
        }
        return sw.toString();
    }

    private long boundary(int int_bit) {
        long v1 = 1;
        return LongStream.range(0, int_bit).map(l -> 10).reduce(v1, (l1, l2) -> l1 * l2);
    }

}
