package com.haibo.yan.algorithm.doublepointer;

/**
 * https://leetcode.com/problems/long-pressed-name/
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        char[] cn = name.toCharArray();
        char[] ct = typed.toCharArray();

        int cns = 0, cne = 0;
        int cts = 0, cte = 0;

        while (cne < cn.length && cte < ct.length) {
            if (cn[cns] != ct[cte]) {
                return false;
            }
            while (cne < cn.length && cn[cne] == cn[cns]) {
                cne++;
            }
            while (cte < ct.length && ct[cte] == ct[cts]) {
                cte++;
            }

            if (cne - cns > cte - cts) {
                return false;
            }
            cns = cne;
            cts = cte;
        }

        return cne == cn.length && cte == ct.length;
    }
}
