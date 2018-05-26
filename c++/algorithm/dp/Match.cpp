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
// Created by Haibo Yan on 5/23/18.
//

#include "Match.h"
#include <vector>

bool Match::wildcard(string p, string s) {
    vector<vector<bool>> dp;

    for (int i = 1; i < p.size() + 1; i++) {
        vector<bool> l(p.size() + 1, true);
        dp.push_back(l);
    }

    for (int i = 0; i < p.size(); i++) {
        for (int j = 0; j < s.size(); j++) {
            if (p[i] == '*') {
                dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
            } else if (p[i] == '?') {
                dp[i + 1][j + 1] = dp[i][j];
            } else {
                dp[i + 1][j + 1] = (p[i] ==  s[j]) && dp[i][j];
            }
        }
    }

    return dp[p.size()][s.size()];
}