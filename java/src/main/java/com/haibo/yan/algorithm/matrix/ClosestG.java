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

import java.util.HashSet;
import java.util.Set;

/**
 * Provide by Bradford Li's facebook interview question.
 *
 * In a matrix, there are characters G, W or space, space represent connection, W represents block wall. Please
 * calculate min steps for every position for min steps can reach G.
 */
public class ClosestG {
    public static int[][] minSteps(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        int[][] closest = new int[rows][columns];

        /**
         * visited has all indices that contains G and W.
         * lastVisited has all indices that contains G only.
         *
         */
        Set<Integer> visited = new HashSet<>();
        Set<Integer> lastVisited = new HashSet<>();


        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char c = board[row][column];
                if ('G' == c) {
                    closest[row][column] = 0;
                    visited.add(row * columns + column);
                    lastVisited.add(row * columns + column);
                } else {
                    if ('W' == c) {
                        visited.add(row * columns + column);
                    }
                    closest[row][column] = Integer.MAX_VALUE;
                }
            }
        }

        int n = visited.size();

        /**
         * If all visited, which means no connections in matrix. return the matrix right away.
         */
        if (n == 0) {
            return closest;
        }

        /**
         * BFS to traverse the matrix until all node visited.
         */
        int[][] moves = new int[][]{
                {-1, 0},
                {0, -1},
                {1,  0},
                {0,  1}
        };
        int step = 0;
        do {
            n = visited.size();
            Set<Integer> neighbors = new HashSet<>();
            for (int pos : lastVisited) {
                int row = pos / columns;
                int column = pos % columns;

                for (int[] move: moves) {
                    int nextR = row + move[0];
                    int nextC = column + move[1];
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < columns) {
                        int nextPos = nextR * columns + nextC;
                        if(!visited.contains(nextPos)) {
                            neighbors.add(nextPos);
                        }
                    }
                }
            }

            step++;
            for (int neighbor: neighbors) {
                int row = neighbor / columns;
                int column = neighbor % columns;
                closest[row][column] = step;
            }
            lastVisited = neighbors;
            visited.addAll(lastVisited);
        } while (n < visited.size());

        return closest;
    }
}

