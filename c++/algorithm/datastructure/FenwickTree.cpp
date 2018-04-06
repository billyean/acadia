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
// Created by Haibo Yan on 12/12/17.
//

#include "FenwickTree.h"

using namespace std;

FenwickTree::FenwickTree(vector<int>& nums) : _sum(nums.size()) {
    for (auto index = 0; index < nums.size(); index++) {
        setNum(index, nums[index]);
    }
}

void FenwickTree::setNum(int index, int num) {
    int v = index;

    while (v < _sum.size()) {
        _sum[v] += num;
        v += (v + 1) & (- (v + 1));
    }
}

int FenwickTree::sum(int index) {
    int sum = 0;

    do {
        sum += _sum[index];
        index -= (index + 1) & (- (index + 1));
    } while (index >= 0);

    return sum;
}

int FenwickTree::rangeSum(int lower, int upper) {
    return sum(upper) - (lower == 0 ? 0 : sum(lower - 1));
}