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

#include "MagicDictionary.h"
#include <algorithm>

void MagicDictionary::buildDict(vector<string> dict) {
    dict_ = dict;
    sort(dict_.begin(), dict_.end());
}

bool MagicDictionary::search(string word) {
    auto l = lower_bound(dict_.begin(), dict_.end(), word);
    auto u = upper_bound(dict_.begin(), dict_.end(), word);


    for (auto iter = prev(l); iter != u; iter++) {
        if (diff(*iter, word) == 1) {
            return true;
        }
    }

    return false;
}

int MagicDictionary::diff(string s1, string s2) {
    if (s1.size() != s2.size()) return -1;

    int diff = 0;

    for (int i = 0; i < s1.size(); i++) {
        if (s1[i] != s2[i]) {
            diff++;
        }
    }

    return diff;
}