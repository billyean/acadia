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
// Created by haibo on 3/24/18.
//

#include "SmallestRange.h"
#include <algorithm>
#include <iostream>

/*
 * see https://leetcode.com/problems/smallest-range
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number
 * from each of the k lists.
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * Example 1:
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Note:
 * The given list may contain duplicates, so ascending order means >= here.
 * 1 <= k <= 3500
 * 105 <= value of elements <= 105.
 * For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.
 */
map<int, set<int>> SmallestRange::merge(vector<vector<int>> &nums) {
    map<int, set<int>> merge_map;

    int r = 0;
    for (auto k = nums.begin(); k != nums.end(); k++) {
        for (auto v = k->begin(); v != k->end(); v++) {
            auto value = *v;
            if (merge_map.find(value) == merge_map.end()) {
                merge_map[value] = {r};
            } else {
                merge_map[value].insert(r);
            }
        }
        r++;
    }

    return merge_map;
}

vector<int> SmallestRange::smallestRange(vector<vector<int>> &nums) {
    map<int, set<int>> merge_map = merge(nums);

    auto s = merge_map.begin(), e = merge_map.begin();
    vector<int> bits;

    for(int i = 0; i < nums.size(); i++) {
        bits.push_back(0);
    }

    int rn =  100000, rx = 400000;

    while (e != merge_map.end()) {
        if (find(bits.begin(), bits.end(), 0) == bits.end()) {
            int r1 = (*s).first;
            int r2 = (*prev(e, 1)).first;

            if (r2 - r1 < rx - rn) {
                rn = r1;
                rx = r2;
            }
            set<int> sv = s -> second;

            for (auto svi = sv.begin(); svi != sv.end(); svi++) {
                bits[*svi]--;
            }
            s++;
        } else {
            set<int> ev = e -> second;
            for (auto evi = ev.begin(); evi != ev.end(); evi++) {
                bits[*evi]++;
            }
            e++;
        }
    }

    while (s != merge_map.end() && find(bits.begin(), bits.end(), 0) == bits.end()) {
        int r1 = (*s).first;
        int r2 = (*prev(e, 1)).first;

        if (r2 - r1 < rx - rn) {
            rn = r1;
            rx = r2;
        }
        set<int> sv = s -> second;

        for (auto svi = sv.begin(); svi != sv.end(); svi++) {
            bits[*svi]--;
        }
        s++;
    }

    return {rn, rx};
}

