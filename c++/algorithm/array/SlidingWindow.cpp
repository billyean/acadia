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
// Created by haibo on 3/13/18.
//

#include "SlidingWindow.h"
#include <deque>
#include <iostream>

// Maintains a deque that max value position in the windows is in the front of deque, all elements less than max value
// following the max value position will be kept as ordered.
vector<int> SlidingWindow::maxWindows(vector<int>& nums, int k) {
    deque<int> deque;
    vector<int> windows;

    cout << endl;
    for (int i = 0; i < nums.size(); i++) {
        int c = nums[i];
        if (deque.size() != 0 && i - deque.front() == k) {
            deque.pop_front();
        }
        while (deque.size() > 0 && c > nums[deque.back()]) {
            deque.pop_back();
        }

        deque.push_back(i);

        if (i >= k - 1) {
            windows.push_back(nums[deque.front()]);
        }
    }

    return windows;
}

string SlidingWindow::min_ordered(string s, string t) {
    int dp[s.size()][t.size()];

    for (int i = 0; i < s.size(); i++) {
        dp[i][0] = s[i] == t[0] ? 1 : 0;
    }

    for (int i = 0; i < t.size(); i++) {
        dp[0][i] = t[i] == s[0] ? 1 : 0;
    }

    for (int i = 1; i < s.size(); i++) {
        for (int j = 1; j < t.size(); j++) {
            if (s[i] == t[j]) {
                dp[i][j] = dp[i-1][j-1] + 1;
            }
        }
    }

    return s;
}