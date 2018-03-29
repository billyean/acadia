//
// Created by haibo on 3/29/18.
// see https://leetcode.com/problems/insert-delete-getrandom-o1
// Design a data structure that supports all following operations in average O(1) time.
// insert(val): Inserts an item val to the set if not already present.
// remove(val): Removes an item val from the set if present.
// getRandom: Returns a random element from current set of elements. Each element must have the same probability of
// being returned.

#include "RandomizedSet.h"
#include <random>

bool RandomizedSet::insert(int val) {
    if (one_map.find(val) == one_map.end()) {
        if (one_map.size() < one_vec.size()) {
            one_vec[one_map.size()] = val;
        } else {
            one_vec.push_back(val);
        }
        one_map.insert({val, one_map.size()});
        return true;
    } else {
        return false;
    }
}

bool RandomizedSet::remove(int val) {
    if (one_map.find(val) != one_map.end()) {
        int vk = one_map[val];
        int len = one_map.size();
        one_map.erase(val);

        if (vk != len - 1) {
            int t = one_vec[len - 1];
            one_vec[len - 1] = one_vec[vk];
            one_vec[vk] = t;
            one_map[t] = vk;
        }
        return true;
    } else {
        return false;
    }
}

int RandomizedSet::getRandom() {
    random_device rd;  //Will be used to obtain a seed for the random number engine
    mt19937 gen(rd());

    uniform_int_distribution<> dis(0, one_map.size() - 1);
    return one_vec[dis(gen)];
}