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
// Created by Haibo Yan on 12/12/17.
// see https://leetcode.com/problems/arranging-coins/description/
// You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
//
// Given n, find the total number of full staircase rows that can be formed.
//
// n is a non-negative integer and fits within the range of a 32-bit signed integer.
//
// Example 1:
//
// n = 5
// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤
//
// Because the 3rd row is incomplete, we return 2.
// Example 2:
//
// n = 8
// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤ ¤
// ¤ ¤
//  Because the 4th row is incomplete, we return 3.
//

#include <complex>
#include "ArrangeCoins.h"

int ArrangeCoins::arrangeCoins(int n) {
    return (int)(-1 + sqrt(1 + 8 * (double)n))  / 2.0;
}
