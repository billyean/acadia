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

#include "Candies.h"

#include <algorithm>
#include <numeric>

int Candies::candy(const vector<int>& ratings) {
    vector<int> candies;
    candies.push_back(1);

    for (int i = 1; i < ratings.size(); i++) {
        if (ratings[i] > ratings[i - 1]) {
            candies.push_back(candies[i - 1] + 1);
        } else {
            candies.push_back(1);
        }
    }

    for (int i = ratings.size() - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = candies[i + 1] + 1;
        }
    }

    return accumulate(candies.begin(), candies.end(), 0);
}
