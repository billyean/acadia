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

package com.haibo.yan.algorithm.dp;

public class MinPath {
    public int minPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[][] min = new int[matrix.length][matrix[0].length];

        min[0][0] = matrix[0][0];

        for (int i = 1; i < matrix[0].length; i++) {
            min[0][i] = min[0][i - 1] + matrix[0][i];
        }

        for (int j = 1; j < matrix.length; j++) {
            min[j][0] = min[j - 1][0] + matrix[j][0];
        }

        for (int j = 1; j < matrix.length; j++) {
            for (int i = 1; i < matrix[0].length; i++) {
                min[j][i] = Integer.min(min[j - 1][i], min[j][i - 1]) + matrix[j][i];
            }
        }

        return min[matrix.length - 1][matrix[0].length - 1];
    }
}
