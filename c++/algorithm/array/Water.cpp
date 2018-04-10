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
// Created by Haibo Yan on 4/10/18.
//

#include "Water.h"

//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
// are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
// forms a container, such that the container contains the most water.
int Water::container(const vector<int>& containers) {
    int m = 0;

    int left = 0, right = containers.size() - 1;

    while (left < right) {
        m = max(m, (right - left) * min(containers[left], containers[right]));
        if (containers[left] < containers[right]) {
            left++;
        } else {
            right--;
        }
    }
    return m;
}


//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
// it is able to trap after raining.
//
//For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 14.
// [0 1 1 2 2 2 2 3 3 3 3 3]
// [0 1 1 2 2 2 2 3 2 2 2 1]
int Water::trapping(const vector<int>& containers) {
    if (containers.size() < 2) {
        return 0;
    }
    vector<int> heights;

    heights.push_back(containers[0]);

    for (int i = 1; i < containers.size(); i++) {
        heights.push_back(max(containers[i], containers[i - 1]));
    }

    for (int i = containers.size() - 1; i >= 0; i--) {
        int m = i == containers.size() - 1 ? containers[i] : max(containers[i], containers[i + 1]);
        heights[i] = min(containers[i], m);
    }

    int t = 0;

    for (int i = 1; i < containers.size(); i++) {
        t += min(containers[i], containers[i - 1]);
    }

    return t;
}


