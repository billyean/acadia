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
package com.haibo.yan.algorithm.graph;

import com.haibo.yan.algorithm.datastructure.BinaryHeap;

import java.util.HashMap;

public class Dijkstra {
    /**
     *
     * @param from
     * @param graph
     * @param <T>
     * @return
     */
    public static <T> HashMap<Vertex<T>, Integer> shorest(Vertex<T> from, WeightDirectGraph<T> graph) {

        HashMap<Vertex<T>, Integer> mapToWeight = new HashMap<>();
        HashMap<Vertex<T>, Integer> visited = new HashMap<>();
        HashMap<Vertex<T>, Vertex<T>> mapToPrev = new HashMap<>();
        BinaryHeap<Vertex<T>, Integer> heap = new BinaryHeap<>(true, v -> mapToWeight.get(v));


        mapToWeight.put(from, 0);
        heap.addElement(from);

        while(!heap.isEmpty()) {
            Vertex<T> min = heap.extract();
            int weight = mapToWeight.get(min);
            visited.put(min, weight);
            mapToWeight.remove(min);
            for (WeightEdge<T> edge : graph.getAllWeightEdges(min)) {
                Vertex<T> to = edge.getTo();
                if (!visited.containsKey(to)) {
                    int newWeight = weight + edge.getWeight();
                    int currentWeight = mapToWeight.get(to);
                    if (currentWeight > newWeight) {
                        mapToWeight.put(to, newWeight);
                        heap.decrease(to);
                    }
                }
            }

        }
        return visited;
    }
}
