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
// Created by haibo on 3/27/18.
//

#include "SubSequence.h"
#include <algorithm>
#include <iostream>

vector<int> SubSequence::longestCommon(vector<int> &other) {
    int dp[nums.size() + 1][other.size() + 1];

    for (int i = 1; i <= other.size(); i++) {
        dp[0][i] = 0;
    }

    for (int i = 1; i <= nums.size(); i++) {
        dp[i][0] = 0;
    }

    for (int i = 1; i <= nums.size(); i++) {
        for (int j = 1; j <= other.size(); j++) {
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            if (nums[i] = other[j]) {
                dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
    }

    vector<int> commons;

    int i = nums.size(), j = other.size();

    while (i > 0 && j > 0) {
        if (dp[i][j] == dp[i - 1][j]) {
            i--;
        } else if (dp[i][j] == dp[i][j - 1]) {
            j--;
        } else {
            commons.push_back(nums[i - 1]);
            i--;
            j--;
        }
    }
    reverse(commons.begin(), commons.end());

    return commons;
}

vector<int> SubSequence::longestIncreasing() {

}

/**
 * see https://leetcode.com/problems/wiggle-subsequence
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate
 * between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence
 * with fewer than two elements is trivially a wiggle sequence.
 *
 *For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and
 * negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 *
 *Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence
 * is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 *
 *Examples:
 *Input: [1,7,4,9,2,5]
 *Output: 6
 *The entire sequence is a wiggle sequence.
 *
 *Input: [1,17,5,10,13,15,10,5,16,8]
 *Output: 7
 *There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 *
 *Input: [1,2,3,4,5,6,7,8,9]
 *Output: 2
 *Follow up:
 *Can you do it in O(n) time?
 */
int SubSequence::wiggleMaxLength() {
    if (nums.size() == 0)
        return 0;
    vector<int> asc;
    vector<int> desc;

    asc.push_back(nums[0]);
    desc.push_back(nums[0]);

    cout << endl;
    for (int i = 1; i < nums.size(); i++) {
        int v = nums[i];
        int ascl = asc.size();
        int descl = desc.size();

        if (v != asc[ascl - 1]) {
            if (ascl == 1 && v > asc[ascl - 1]) {
                asc.push_back(v);
            } else if (ascl > 1) {
                int wiggle = (asc[ascl - 1] - asc[ascl - 2]) ^ (v - asc[ascl - 1]);
                if (wiggle < 0) {
                    asc.push_back(v);
                } else {
                    asc[ascl - 1] = v;
                }
            }
        }

        if (v != desc[descl - 1]) {
            if (descl == 1 && v < desc[descl - 1]) {
                desc.push_back(v);
            } else if (descl > 1) {
                int wiggle = (desc[descl - 1] - desc[descl - 2]) ^ (v - desc[descl - 1]) ;
                if (wiggle  < 0) {
                    desc.push_back(v);
                } else {
                    desc[descl - 1] = v;
                }
            }
        }
    }

    return max(asc.size(), desc.size());
}