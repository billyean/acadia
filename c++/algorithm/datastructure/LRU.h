//Copyright [2018] [Haibo Yan]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//
// Created by Haibo Yan on 5/23/18.
//

#ifndef ALGORITHM_LRU_H
#define ALGORITHM_LRU_H

#include <map>

using namespace std;

template <class K, class V> class Node;

template <class K, class V>
class LRU {
public:
    LRU(int capacity): capacity_(capacity) {}

    void put(K key, V value);

    V *get(K key);
private:
    Node<K,V>* remove(Node<K,V>* node);
    void add(Node<K,V> *node);
    Node<K,V> *head;
    Node<K,V> *tail;
    map<K, Node<K, V>> dict;

    int capacity_;
};

template <class K, class V>
class Node {
public:
    friend class LRU<K, V>;
    Node(K key, V value): k(key), v(value){}
private:
    K k;
    V v;
    Node<K, V> *prev;
    Node<K, V> *next;
};
//
//
//
//template <class K, class V>
//void LRU::put(K key, V value) {
//    if (dict.find(key) == dict.end()) {
//        Node<K, V> node = dict[key];
//        node.v = value;
//        remove(&node);
//        add(&node);
//    } else {
//        if (dict.size() == capacity_) {
//            Node<K, V> *obsolete = remove(head);
//            dict.erase(obsolete->k);
//        }
//        Node<K, V> node(key, value);
//        add(&node);
//    }
//}
//
//template <class K, class V>
//V *LRU::get(K key) {
//    if (dict.find(key) == dict.end()) {
//        return NULL;
//    } else {
//        Node<K, V> node = dict[key];
//        remove(&node);
//        add(&node);
//        return &(node.v);
//    }
//}
//
//
//
//template <class K, class V>
//void LRU::add(Node<K,V> *node) {
//    if (tail) {
//        tail->next = node;
//        node->prev = tail;
//        tail = node;
//    } else {
//        head = node;
//        tail = node;
//    }
//}
//
//template <class K, class V>
//Node* LRU::remove(Node<K, V> *node) {
//    if (head == node) {
//        head = node->next;
//    } else {
//        node->prev->next = node->next;
//    }
//
//    if (tail == node) {
//        tail = node->prev;
//    } else {
//        node->next->prev = node->prev;
//    }
//}
#endif //ALGORITHM_LRU_H
