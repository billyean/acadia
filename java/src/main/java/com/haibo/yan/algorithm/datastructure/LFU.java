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

public class LFU<K, V> {
    FeqListNode<DoubleLinkedList<K, V>> freqList;

    HashMap<K, LinkedDLLNode<K, V>> map = new HashMap();

    private final int capacity;

    public LFU(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        LinkedDLLNode<K, V> node = map.get(key);
        upgrade(node);
        return node.value;
    }

    public void set(K key, V value) {
        if (map.size() == capacity) {
            while (freqList.val.head == null) {
                freqList = (FeqListNode<DoubleLinkedList<K, V>>)freqList.next;
            }

            map.remove(freqList.val.head.key);
            if (freqList.val.head == freqList.val.tail) {

                freqList = (FeqListNode<DoubleLinkedList<K, V>>)freqList.next;
            } else {
                DoubleLinkedList<K, V> list = freqList.val;
                list.remove(list.head);
            }
        }

        LinkedDLLNode<K, V> node;
        if (!map.containsKey(key)) {
            node = new LinkedDLLNode<>(key, value, null);
            if (freqList == null || freqList.feq != 1) {
                DoubleLinkedList<K, V> dll = new DoubleLinkedList<>();
                FeqListNode<DoubleLinkedList<K, V>> newFreqList = new FeqListNode(dll);
                newFreqList.next = freqList;
                freqList = newFreqList;
            }
            freqList.val.append(node);
            node.freqList = freqList;
            freqList.feq = 1;
        } else {
            node = map.get(key);
            node.value = value;
            upgrade(node);
        }

        map.put(key, node);
    }

    private void upgrade(LinkedDLLNode<K, V> node) {
        FeqListNode<DoubleLinkedList<K, V>> current = node.freqList;
        FeqListNode<DoubleLinkedList<K, V>> next = (FeqListNode<DoubleLinkedList<K, V>>)current.next;
        removeNode(node);
        if (next == null || next.feq != current.feq + 1) {
            DoubleLinkedList<K, V> dlList = new DoubleLinkedList();
            FeqListNode<DoubleLinkedList<K, V>> newFreqListNode = new FeqListNode(dlList);
            current.next = newFreqListNode;
            newFreqListNode.next = next;
            next = newFreqListNode;
            next.feq = current.feq + 1;
            node.freqList = newFreqListNode;
        }
        appendNode(next.val, node);
        node.freqList = next;
    }

    private void removeNode(LinkedDLLNode<K, V> node) {
        DoubleLinkedList<K, V> list = node.freqList.val;
        list.remove(node);
    }

    private void appendNode(DoubleLinkedList<K, V> list, LinkedDLLNode<K, V> node) {
        list.append(node);
    }

}
