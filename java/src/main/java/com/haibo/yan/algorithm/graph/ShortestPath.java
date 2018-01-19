/*
 *
 *  * Copyright [2018] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.graph;

import java.util.*;

/**
 * Using DFS to search shortest path from vertex s to vertex t.
 */
public class ShortestPath {
    public <T> List<Edge<T>> shortest(Vertex<T> s, Vertex<T> t, UndirectGraph<T, Edge<T>> graph) {
        List<Edge<T>> path = new ArrayList<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        HashSet<Vertex<T>> visited = new HashSet<>();
        HashMap<Vertex<T>, Edge<T>> vToPrev = new HashMap<>();

        if (s != t) {
            visited.add(s);
            queue.offer(s);

            while (!queue.isEmpty()) {
                Vertex<T> h = queue.poll();
                for (Edge<T> e : graph.getAllEdges(h)) {
                    Vertex<T> o = e.from == h ? e.to : e.from;
                    if (!visited.contains(o)) {
                        visited.add(o);
                        vToPrev.put(o, e);
                        queue.offer(o);
                        if (t == o) {
                            break;
                        }
                    }
                }
            }

            if (vToPrev.containsKey(t)) {
                Vertex<T> c = t;
                while (c != s) {
                    Edge<T> e = vToPrev.get(c);
                    path.add(0, e);
                    c = e.from == c ? e.to : e.from;
                }
            }
        }

        return path;
    }
}
