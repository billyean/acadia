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
// Created by Haibo Yan on 6/1/18.
//

#include "HouseRobber.h"

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
// stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
// connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
// money you can rob tonight without alerting the police.
int HouseRobber::rob1(vector<int> nums) {
    return maxRob(nums, 0, nums.size());
}

//After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will
// not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house
// is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the
// previous street.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
// money you can rob tonight without alerting the police.
int HouseRobber::rob2(vector<int> nums) {
    return max(maxRob(nums, 0, nums.size() - 1), maxRob(nums, 1, nums.size() - 1)) ;
}

int HouseRobber::maxRob(vector<int> nums, int s, int len) {
    if (len <= 0) {
        return 0;
    }

    vector<int> values(len + 1, 0);
    values[1] = nums[s];

    for (int i = 1; i < len; i++) {
        values[i + 1] = max(values[i], values[i - 1] + nums[s + i]);
    }

    return values[s + len - 1];
}