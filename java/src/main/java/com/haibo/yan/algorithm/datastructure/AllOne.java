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

package com.haibo.yan.algorithm.datastructure;

import java.util.HashMap;
import java.util.HashSet;

import static java.util.stream.Collectors.joining;

public class AllOne {
    private static class Bucket {
        Bucket prev;

        Bucket next;

        int value;

        final HashSet<String> keys;

        Bucket(int value, String key) {
            this.value = value;
            keys = new HashSet<>();
            keys.add(key);
        }

        @Override
        public String toString() {
            return String.format("value = %d, keys = %s", value, keys.stream().collect(joining(",", "[", "]")));
        }
    }

    final HashMap<String, Bucket> keyToBucket;

    private Bucket head;

    private Bucket tail;

    /** Initialize your data structure here. */
    public AllOne() {
        keyToBucket = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int value = 0;
        Bucket before = null;
        if (keyToBucket.containsKey(key)) {
            Bucket bucket = keyToBucket.get(key);
            bucket.keys.remove(key);
            value = bucket.value;
            before = bucket;
        }
        value++;

        Bucket b;
        if (before == null && head != null && head.value == value) {
            b = head;
            b.keys.add(key);
        } else if (before != null && before.next != null && before.next.value == value) {
            b = before.next;
            b.keys.add(key);
        } else {
            b = new Bucket(value, key);
            insertAfter(b, before);
        }
        keyToBucket.put(key, b);
        if (b.prev != null && b.prev.keys.isEmpty()) {
            remove(b.prev);
        }

        System.out.printf("After inc %s\n", key);
        System.out.printf("\thead = %s\n", head);
        System.out.printf("\ttail = %s\n", tail);
    }


    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

        if (keyToBucket.containsKey(key)) {
            Bucket bucket = keyToBucket.get(key);
            Bucket after = bucket;
            int value = bucket.value;
            bucket.keys.remove(key);
            value--;

            Bucket b;

            if (value != 0) {
                if (after.prev != null && after.prev.value == value) {
                    b = after.prev;
                    b.keys.add(key);
                } else {
                    b = new Bucket(value, key);
                    insertBefore(b, after);
                }

                keyToBucket.put(key, b);
                if (b.next != null && b.next.keys.isEmpty()) {
                    remove(b.next);
                }
            } else if (head.keys.isEmpty()) {
                remove(head);
            }
        }

        System.out.printf("After dec %s\n", key);
        System.out.printf("\thead = %s\n", head);
        System.out.printf("\ttail = %s\n", tail);
    }

    private void remove(Bucket bucket) {
        Bucket prev = bucket.prev;
        Bucket next = bucket.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }
    }

    private void insertBefore(Bucket bucket, Bucket next) {
        if (next == null) {
            bucket.prev = tail;
            if (tail != null) {
                tail.next = bucket;
            }
            tail = bucket;
            if (head == null) {
                head = bucket;
            }
        } else {
            Bucket before = next.prev;
            next.prev = bucket;
            bucket.next = next;
            bucket.prev = before;
            if (before != null) {
                before.next = bucket;
            } else {
                head = bucket;
            }
        }
    }

    private void insertAfter(Bucket bucket, Bucket prev) {
        if (prev == null) {
            bucket.next = head;
            if (head != null) {
                head.prev = bucket;
            }
            head = bucket;
            if (tail == null) {
                tail = bucket;
            }
        } else {
            Bucket after = prev.next;
            prev.next = bucket;
            bucket.prev = prev;
            bucket.next = after;
            if (after != null) {
                after.prev = bucket;
            } else {
                tail = bucket;
            }
        }
    }


    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail == null ? "" : tail.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head == null ? "" : head.keys.iterator().next();
    }

    public static void main(String[] args) {
        AllOne ao = new AllOne();
        ao.inc("hello");
        ao.inc("world");
        ao.inc("hello");
        ao.dec("world");
        ao.inc("hello");
        ao.inc("leet");

        System.out.println(ao.getMaxKey());
        ao.dec("hello");
        ao.dec("hello");
        ao.dec("hello");

        System.out.println(ao.getMaxKey());

    }
}
