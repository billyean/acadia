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
// Created by haibo on 3/28/18.
//

#include "MaxChunks.h"
#include <iostream>

// see https://leetcode.com/problems/max-chunks-to-make-sorted and
//     https://leetcode.com/problems/max-chunks-to-make-sorted-ii
// Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of
// "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
// What is the most number of chunks we could have made?
// Example 1:
// Input: arr = [4,3,2,1,0]
// Output: 1
// Explanation:
// Splitting into two or more chunks will not return the required result.
// For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't_ sorted.
// Example 2:
// Input: arr = [1,0,2,3,4]
// Output: 4
// Explanation:
// We can split into two chunks, such as [1, 0], [2, 3, 4].
// However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
// Note:
// arr will have length in range [1, 10].
// arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
int MaxChunks::maxChunksToSorted() {
    vector<int> asc;

    asc.push_back(arr[0]);

    for (int i = 1; i < arr.size(); i++) {
        int m = arr[i];
        while (asc.size() > 0 &&  arr[i] < asc[asc.size() - 1]) {
            m = max(m, asc[asc.size() - 1]);
            asc.pop_back();
        }
        asc.push_back(m);
    }

    return asc.size();
}