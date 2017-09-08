package com.haibo.yan.algorithm.uglynumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        if (n < 0) throw new IllegalArgumentException("n can't be less than 1");
        if (n == 1) return 1;

        LinkedList<Integer> uglyNumberQueue = new LinkedList<>();
        HashMap<Integer, Integer> uglyNumberMap = new HashMap<>();

        uglyNumberQueue.offer(1);
        uglyNumberMap.put(1, 0);

        while (--n > 0) {
            int v0 = uglyNumberQueue.get(0);
            int vn0 = getNext(v0, uglyNumberMap.get(v0));

            int vn1 = Integer.MAX_VALUE;
            if (uglyNumberQueue.size() > 1) {
                int v1 = uglyNumberQueue.get(1);
                vn1 = getNext(v1, uglyNumberMap.get(v1));
            }

            int vn2 = Integer.MAX_VALUE;
            if (uglyNumberQueue.size() > 2) {
                int v2 = uglyNumberQueue.get(2);
                vn2 = getNext(v2, uglyNumberMap.get(v2));
            }

            int min = Integer.min(vn0, Integer.min(vn1, vn2));
            uglyNumberQueue.offer(min);
            uglyNumberMap.put(min, 0);

            if (min == vn0) {
                int v =  uglyNumberQueue.get(0);
                uglyNumberMap.put(v, uglyNumberMap.get(v) + 1);

            }

//            if (min == vn1) l1++;
//            if (min == vn2) l2++;
//
//            if (l0 == 3) {
//                int removed = uglyNumberQueue.poll();
//                uglyNumberSet.remove(removed);
//                l0 = l1;
//                l1 = l2;
//                l2 = 0;
//            }
        }

        return uglyNumberQueue.getLast();
    }

    private int getNext(int current, int pos) {
        switch (pos) {
            case 0:
                return current * 2;
            case 1:
                return current * 3;
            case 2:
                return current * 5;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = 1; i < 21; i++) {
            System.out.println(solution.nthUglyNumber(i));
        }
    }
}
