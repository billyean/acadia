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
// Created by haibo on 3/28/18.
//

#include "TaskScheduler.h"

#include <algorithm>
#include <iostream>

int TaskScheduler::leastInterval(vector<char> &tasks, int n) {
    int tasks_num[26];

    for (int i = 0; i < 26; i++) {
        tasks_num[i] = 0;
    }

    for (auto ti = tasks.begin(); ti != tasks.end(); ti++) {
        tasks_num[(*ti) - 'A']++;
    }

    vector<int> tn;

    for (int i = 0; i < 26; i++) {
        if (tasks_num[i] != 0) {
            tn.push_back(tasks_num[i]);
        }
    }

    sort(tn.begin(), tn.end());
    reverse(tn.begin(), tn.end());

    int intervals = 0;

    while (tn.size() > 0) {
        int index = tn.size() - 1;
        int l = tn[index];
        while (index >= 0 && tn.size() - index - 1 < n + 1) {
           tn[index] -= l;
           index--;
        }

        if (intervals == 0 && tn.size() < n + 1) {
            intervals -= n + 1 - tn.size();
        }
        intervals += (n + 1) * l;

        while (tn.size() > 0 && tn[tn.size() - 1] == 0) {
            tn.pop_back();
        }
    }

    return intervals;
}