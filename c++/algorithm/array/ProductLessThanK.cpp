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
// Created by Haibo Yan on 4/4/18.
//

#include "ProductLessThanK.h"

int ProductLessThanK::numbers(vector<int>& nums, int k) {
    int n = 0;
    long product = 1, left = -1;

    for (int i = 0; i < nums.size(); i++) {
        product *= nums[i];
        while (left < i && product > k) {
            product /= nums[++left];
        }
        n++;
    }

    return n;
}