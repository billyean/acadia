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

package com.haibo.yan.algorithm.graph;

import java.util.*;

public class TopologySort{
    /**
     * DFS solution for topology sort
     * @param vertices
     * @param edges
     * @param <T>
     * @return
     */
    public static <T> List<Vertex<T>>  sort(Set<Vertex<T>> vertices, List<Edge<T>> edges) {
        Set<Vertex<T>> visited = new HashSet<>();
        Stack<Vertex<T>> topology = new Stack<>();

        DirectGraph<T> graph = new DirectGraph(vertices);

        for (Edge<T> edge : edges) {
            graph.addEdge(edge);
        }

        for (Vertex<T> vertex : vertices) {
            visit(vertex, visited, topology, graph);
        }

        List<Vertex<T>> sorted = new ArrayList<>();

        while (!topology.isEmpty()) {
            sorted.add(topology.pop());
        }

        return sorted;
    }

    private static <T> void visit(Vertex<T> vertex, Set<Vertex<T>> visited, Stack<Vertex<T>> topology, DirectGraph<T> graph) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            List<Vertex<T>> adjacents = graph.getAdjacents(vertex);
            for (Vertex<T> adjacent : adjacents) {
                visit(adjacent, visited, topology, graph);
            }
            topology.push(vertex);
        }
    }
}
