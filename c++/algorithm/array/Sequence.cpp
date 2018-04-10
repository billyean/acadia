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

#include "Sequence.h"
#include <set>

int Sequence::longestConsecutive(vector<int>& nums) {
    set<int> sn;

    for (auto it = nums.begin(); it != nums.end(); it++) {
        sn.insert(*it);
    }

    auto maxc = 0;

    for (auto it = nums.begin(); it != nums.end(); it++) {
        auto c = *it;
        auto l = c - 1;
        auto r = c + 1;
        auto count = 1;

        set<int>::iterator sni;
        while ((sni = sn.find(l)) != sn.end()) {
            count++;
            sn.erase(sni);
            l--;
        }
        while ((sni = sn.find(r)) != sn.end()) {
            count++;
            sn.erase(sni);
            r++;
        }

        maxc = max(maxc, count);
    }

    return maxc;
}
