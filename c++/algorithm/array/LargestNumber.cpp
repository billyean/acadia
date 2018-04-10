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
// Given a list of non negative integers, arrange them such that they form the largest number.
//
// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. (Note: The result may be very large, so
// you need to return a string instead of an integer.)
//

#include "LargestNumber.h"
#include <algorithm>
#include <numeric>

// 91910 91 9191910
// 9191991 91 919199191
string LargestNumber::largest(vector<string>& nums) {
    sort(nums.begin(), nums.end(), [](const string& s1, const string& s2) -> bool {
       return s2 + s1 < s1 + s2;
    });

    string ln = "";
    for (auto it = nums.begin(); it != nums.end(); it++) {
        ln += *it;
    }
    return accumulate(nums.begin(), nums.end(), string());
}
