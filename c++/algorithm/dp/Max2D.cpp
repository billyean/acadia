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
// Created by Haibo Yan on 4/5/18.
//

#include "Max2D.h"
#include <stack>

int Max2D::square(vector<vector<char>>& board) {
    int r = board.size();
    if (r == 0) {
        return 0;
    }
    int c =  board[0].size();
    if (c == 0) {
        return 0;
    }
    int dp[r][c];

    for (int i = 0; i < r; i++) {
        dp[i][0] = board[i][0] == '1' ? 1 : 0;
    }
    for (int j = 1; j < c; j++) {
        dp[0][j] = board[0][j] == '1' ? 1 : 0;
    }

    for (int i = 1; i < r; i++) {
        for (int j = 1; j < c; j++) {
            if (board[i][j] == '0') {
                dp[i][j] = 0;
            } else {
                dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
    }

    int maxl = 0;

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            maxl = max(maxl, dp[i][j]);
        }
    }

    return maxl * maxl;
}

int Max2D::histogram(vector<int>& heights) {
    if (heights.size() == 0) {
        return 0;
    }

    stack<int> asc;
    asc.push(0);
    int area = heights[0];

    for (int i = 1; i < heights.size(); i++) {
        while (asc.size() > 0 && heights[asc.top()] > heights[i]) {
            asc.pop();
        }
        area = max(area, asc.size() == 0 ? heights[i] * i : heights[asc.top()] * (i - asc.top()));
        asc.push(i);
    }

    while (asc.size() != 0) {
        int i = asc.top();
        asc.pop();
        area = max(area, asc.size() == 0 ? heights[i] * i : heights[asc.top()] * (i - asc.top()));
    }

    return area;
}
