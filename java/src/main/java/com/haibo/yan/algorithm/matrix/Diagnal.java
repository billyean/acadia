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

package com.haibo.yan.algorithm.matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class Diagnal {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> diagnal = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                System.out.printf("[%d, %d]\n", j, i - j);
                line.add(a.get(j).get(i - j));
            }
            diagnal.add(line);
        }

        for (int i = 1; i < a.size(); i++) {
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = a.size() - 1; j >= i; j--) {
                System.out.printf("[%d, %d]\n", j, j);
                line.add(a.get(i).get(j));
            }
            diagnal.add(line);

        }
        return diagnal;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList(Arrays.asList(1, 2, 3)));
                add(new ArrayList(Arrays.asList(4, 5, 6)));
                add(new ArrayList(Arrays.asList(7, 8, 9)));
            }
        };

        new Diagnal().diagonal(l);
    }
}
