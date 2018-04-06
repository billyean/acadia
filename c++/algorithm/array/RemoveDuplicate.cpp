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
// Created by Haibo Yan on 3/13/18.
//

#include "RemoveDuplicate.h"
#include <map>


int RemoveDuplicate::removeDuplicates(vector<int>& nums) {
    int newLen = 0;

    if (nums.size() > 0) {
        int pos = 0;
        int current = nums[pos++];
        newLen = 1;

        while (pos < nums.size()) {
            if (nums[pos] != current) {
                nums[newLen++] = nums[pos];
                current = nums[pos];
            }
            pos++;
        }
    }
    return newLen;
}

int RemoveDuplicate::removeDuplicateAtMostTwice(vector<int>& nums) {
    int newLen = 0;
    map<int, int> dmap;

    for (int i = 0; i < nums.size(); i++) {
        int v = nums[i];

        if (dmap[v] < 2) {
            nums[newLen++] = v;
            dmap[v] += 1;
        }
    }
    return newLen;
}
