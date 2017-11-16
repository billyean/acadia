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
package com.haibo.yan.algorithm.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * see https://leetcode.com/problems/spiral-matrix
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * For example,
     * Given the following matrix:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * You should return [1,2,3,6,9,8,7,4,5].
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int m = matrix.length, n = matrix[0].length;
        int l = (Math.min(m, n) + 1) / 2;

        for (int i = 0; i < l; i++) {
            int r = i, c = i;
            int di = 0;
            do {
                list.add(matrix[r][c]);
                switch (di) {
                    case 0:
                        if (c == n - i - 1) {
                            di = 1;
                            r++;
                        } else {
                            c++;
                        }
                        break;
                    case 1:
                        if (r == m - i - 1) {
                            di = 2;
                            c--;
                        } else {
                            r++;
                        }
                        break;
                    case 2:
                        if (c == i) {
                            di = 3;
                            r--;
                        } else {
                            c--;
                        }
                        break;
                    case 3:
                        if (r == i) {
                            di = 0;
                        } else {
                            r--;
                        }
                        break;
                }
                if (r == i - 1 || r == m - i || c == i - 1 || c == n - i) {
                    break;
                }
            } while (r != i || c != i);
        }

        return list;
    }

    /**
     *
     * see https://leetcode.com/problems/spiral-matrix-ii
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * For example,
     * Given n = 3,
     *
     * You should return the following matrix:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        if (n > 0) {
            int l = (n + 1) / 2;
            int v = 0;

            for (int i = 0; i < l; i++) {
                int r = i, c = i;
                int di = 0;
                do {
                    matrix[r][c] = ++v;
                    switch (di) {
                        case 0:
                            if (c == n - i - 1) {
                                di = 1;
                                r++;
                            } else {
                                c++;
                            }
                            break;
                        case 1:
                            if (r == n - i - 1) {
                                di = 2;
                                c--;
                            } else {
                                r++;
                            }
                            break;
                        case 2:
                            if (c == i) {
                                di = 3;
                                r--;
                            } else {
                                c--;
                            }
                            break;
                        case 3:
                            if (r == i) {
                                di = 0;
                            } else {
                                r--;
                            }
                            break;
                    }
                    if (r == i - 1 || r == n - i || c == i - 1 || c == n - i) {
                        break;
                    }
                } while (r != i || c != i);
            }
        }

        return matrix;
    }


}
