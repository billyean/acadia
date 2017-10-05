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

package com.haibo.yan.algorithm.tree;

import com.haibo.yan.algorithm.graph.Edge;
import com.haibo.yan.algorithm.graph.TopologySort;
import com.haibo.yan.algorithm.graph.Vertex;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class TestTopologySort {
    @DataProvider
    public Object[][] topologySortDP(){
        // Test 1
        Set<Vertex<Integer>> vertices1 = new HashSet<>();
        Vertex<Integer> v0 = Vertex.createVertex(0, Integer.class);
        vertices1.add(v0);
        Vertex<Integer> v1 = Vertex.createVertex(1, Integer.class);
        vertices1.add(v1);
        Vertex<Integer> v2 = Vertex.createVertex(2, Integer.class);
        vertices1.add(v2);
        Vertex<Integer> v3 = Vertex.createVertex(3, Integer.class);
        vertices1.add(v3);
        Vertex<Integer> v4 = Vertex.createVertex(4, Integer.class);
        vertices1.add(v4);
        Vertex<Integer> v5 = Vertex.createVertex(5, Integer.class);
        vertices1.add(v5);

        List<Edge<Integer>> edges1 = new ArrayList<>();
        edges1.add(new Edge(v5, v2));
        edges1.add(new Edge(v5, v0));
        edges1.add(new Edge(v4, v0));
        edges1.add(new Edge(v4, v1));
        edges1.add(new Edge(v2, v3));
        edges1.add(new Edge(v3, v1));

        // Test 2
        Set<Vertex<Character>> vertices2 = new HashSet<>();
        Vertex<Character> va = Vertex.createVertex('A', Character.class);
        vertices2.add(va);
        Vertex<Character> vb = Vertex.createVertex('B', Character.class);
        vertices2.add(vb);
        Vertex<Character> vc = Vertex.createVertex('C', Character.class);
        vertices2.add(vc);
        Vertex<Character> vd = Vertex.createVertex('D', Character.class);
        vertices2.add(vd);
        Vertex<Character> ve = Vertex.createVertex('E', Character.class);
        vertices2.add(ve);
        Vertex<Character> vf = Vertex.createVertex('F', Character.class);
        vertices2.add(vf);
        Vertex<Character> vg = Vertex.createVertex('G', Character.class);
        vertices2.add(vg);

        List<Edge<Integer>> edges2 = new ArrayList<>();
        edges2.add(new Edge(va, vc));
        edges2.add(new Edge(vb, vc));
        edges2.add(new Edge(vc, ve));
        edges2.add(new Edge(vb, vd));
        edges2.add(new Edge(ve, vf));
        edges2.add(new Edge(vd, vf));
        edges2.add(new Edge(vf, vg));

        return new Object[][]{
                {vertices1, edges1, Arrays.asList(5, 2, 4, 0, 3, 1)},
                {vertices2, edges2, Arrays.asList('B', 'D', 'A', 'C', 'E', 'F', 'G')},
        };
    }

    @Test(dataProvider = "topologySortDP")
    public <T> void test(Set<Vertex<T>> vertices, List<Edge<T>> edges, List<T> expected) {
        List<T> topology= TopologySort.sort(vertices, edges).stream().map(Vertex::value).collect(Collectors.toList());

        for(T t: topology) {
            System.out.println(t);
        }
//        assertEquals(topology, expected);
    }
}
