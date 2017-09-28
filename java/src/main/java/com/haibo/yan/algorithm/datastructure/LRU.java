package com.haibo.yan.algorithm.datastructure;

import java.util.HashMap;

public class LRU<K, V> {

    private HashMap<K, DoubleLinkedListNode<K, V>> map = new HashMap<>();

    private DoubleLinkedList<K, V> list = new DoubleLinkedList<>();

    private final int capacity;

    public LRU(int capacity){
        this.capacity = capacity;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        DoubleLinkedListNode<K, V> node = map.get(key);
        list.remove(node);
        list.append(node);
        return node.value;
    }

    public void set(K key, V value) {
        DoubleLinkedListNode<K, V> node = map.containsKey(key)
                ? map.get(key) : new DoubleLinkedListNode(key, value);

        if (map.containsKey(key)) {
            list.remove(node);
        } else if (map.keySet().size() == capacity) {
            K rKey = list.head.key;
            list.remove(list.head);
            map.remove(rKey);
        }
        list.append(node);

        map.put(key, node);
    }

    public int size() {
        return map.keySet().size();
    }

}
