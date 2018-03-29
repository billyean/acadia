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