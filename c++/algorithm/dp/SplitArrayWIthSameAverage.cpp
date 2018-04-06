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
// see https://leetcode.com/contest/weekly-contest-77/problems/split-array-with-same-average/
// In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start
// empty.)
// Return true if and only if after such a move, it is possible that the average value of B is equal to the average v
// alue of C, and B and C are both non-empty.
// Example :
// Input:
// [1,2,3,4,5,6,7,8]
// Output: true
// Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
// Note:
// The length of A will be in the range [1, 30].
// A[i] will be in the range of [0, 10000].

#include "SplitArrayWIthSameAverage.h"
#include <algorithm>
#include <numeric>
#include <set>

bool SplitArrayWIthSameAverage::splitArraySameAverageWithK(vector<int>& A, int k, int left, int leftNum,  int sum) {
    if (k >= A.size()) {
        return false;
    }

    int v = A[k];

    if (leftNum >= A.size() / 2) {
        return false;
    }

    if (A.size() - leftNum - 1 > 0){
        if ((left + v) * 1.0 / (leftNum + 1) == (sum - left - v) * 1.0 / (A.size() - leftNum - 1)) {
            return true;
        }
    }

    if (splitArraySameAverageWithK(A, k + 1, left + v, leftNum + 1, sum)) {
        return true;
    }

    if (splitArraySameAverageWithK(A, k + 1, left, leftNum, sum)) {
        return true;
    }

    return false;
}

bool SplitArrayWIthSameAverage::splitArraySameAverage(vector<int>& A) {
    sort(A.begin(), A.end());
    int sum = accumulate(A.begin(), A.end(), 0);
    return splitArraySameAverageWithK(A, 0, 0, 0, sum);
}

bool SplitArrayWIthSameAverage::splitArraySameAverageDP(vector<int>& A) {
    sort(A.begin(), A.end());

    int sum = accumulate(A.begin(), A.end(), 0);
    double ave = (double)sum / A.size();
    vector<set<int>> dp;

    dp.push_back({0});
    for (int i = 0; i < sum; i++) {
        dp.push_back({});
    }

    for (int i = 0; i < A.size(); i++) {
        for (int j = sum - 1; j >= 0; j--) {
            int nextsum = j + A[i];
            if (dp[j].size() != 0 && nextsum < sum) {
                set<int> c = dp[j];
                set<int> nc = dp[nextsum];

                for (auto ic = c.begin(); ic != c.end(); ic++) {
                    int count = *ic;

                    if (nc.find(count + 1) == nc.end()) {
                        if ((double)nextsum / (count + 1) == ave) {
                            return true;
                        }
                        nc.insert(count + 1);
                        dp[nextsum] = nc;

                    }
                }
            }
        }
    }

    return false;
}