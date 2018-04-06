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
// Created by Haibo Yan on 4/1/18.
//

#include "SubsetSum.h"
#include <algorithm>

vector<int> SubsetSum::subsetToK(int k) {
    bool equals[numbers_.size()][k + 1];

    for (int i = 0; i < numbers_.size(); i++) {
        for (int j = 0; j <= k; j++) {
            if (j == 0) {
                equals[i][j] = true;
            } else {
                equals[i][j] = false;
            }
        }
    }
    equals[0][numbers_[0]] = true;

    for (int i = 1; i < numbers_.size(); i++) {
        for (int j = 1; j <= k; j++) {
            if (equals[i - 1][j] || (j >= numbers_[i] && equals[i - 1][j - numbers_[i]])) {
                equals[i][j] = true;
            }
        }
    }

    vector<int> subset;

    if (equals[numbers_.size() - 1][k]) {
        int n = k;
        for (int i = numbers_.size() - 1; i >= 0; i--) {
            if ((i > 0 && !equals[i - 1][n]) || (i == 0 && n != 0)) {
                subset.push_back(numbers_[i]);
                n -= numbers_[i];
            }
        }
    }
    sort(subset.begin(), subset.end());

    return subset;

}
