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

package com.haibo.yan.algorithm.datastructure;

import java.util.HashMap;

public class UnionFind<T> {

    private static class Node<T> {

        private final T value;

        private int weight;

        private Node<T> parent;

        Node(T value) {
            this.value = value;
            weight = 1;
        }
        public T getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> findRoot() {
            if (parent != null) {
                return parent.findRoot();
            }

            return this;
        }
    }

    HashMap<T, Node<T>> nodesMap = new HashMap<>();

    private int setSize = 0;

    public void add(T value) {
        Node<T> node = new Node(value);
        nodesMap.put(value, node);
        setSize++;
    }

    public T findSet(T value) {
        return nodesMap.get(value).findRoot().getValue();
    }

    public void union(T value1, T value2) {
        Node<T> node1 = nodesMap.get(value1), node2 = nodesMap.get(value2);

        Node<T> root1 = node1.findRoot(), root2 = node2.findRoot();

        if (root1 != root2) {
            int max = Integer.max(root1.getWeight(), root2.getWeight());

            if (max == root1.getWeight()) {
                root2.setParent(root1);
                root1.setWeight(root1.getWeight() + root2.getWeight());
            } else {
                root1.setParent(root2);
                root2.setWeight(root1.getWeight() + root2.getWeight());
            }
        }
    }


}
