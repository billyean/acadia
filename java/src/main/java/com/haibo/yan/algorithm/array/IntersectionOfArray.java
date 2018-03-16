package com.haibo.yan.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOfArray {
  /**
   *
   * see http://www.lintcode.com/en/problem/intersection-of-arrays/
   * Give a number of arrays, find their intersection, and output their
   * intersection size.
   *
   * Example
   * Given [[1,2,3],[3,4,5],[3,9,10]], return 1
   * explanation:
   * Only element 3 appears in all arrays, the intersection is [3], and the size
   * is 1.
   *
   * Given [[1,2,3,4],[1,2,5,6,7][9,10,1,5,2,3]], return 2
   * explanation:
   * Only element 1,2 appear in all arrays, the intersection is [1,2], the size
   * is 2.
   * @param arrs
   * @return
   */
  public int intersectionOfArrays(int[][] arrs) {
    // write your code here
    HashMap<Integer, Integer> vg = new HashMap<>();

    int l = arrs.length;

    for (int i = 0; i< arrs.length; i++) {
      HashSet<Integer> hs = new HashSet<>();
      for (int j = 0; j < arrs[i].length; j++) {
        hs.add(arrs[i][j]);
      }
      for (int v :  hs) {
        vg.put(v, vg.getOrDefault(v, 0) + 1);
      }
    }

    int inter = 0;

    for (int v : vg.values()) {
      if (v == l) {
        inter++;
      }
    }

    return inter;
  }
}
