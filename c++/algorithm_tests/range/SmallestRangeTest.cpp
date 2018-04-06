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

#include "gtest/gtest.h"
#include "../../algorithm/range/SmallestRange.h"

TEST(SmallestRangeTest, simple) {
    vector<vector<int>> test_data = {{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}};
    vector<int> expected = {20, 24};
    ASSERT_EQ(SmallestRange().smallestRange(test_data), expected);
}

TEST(SmallestRangeTest, simple2) {
    vector<vector<int>> test_data = {{4, 10, 15, 24, 26, 30}, {0, 9, 12, 20, 30}, {5, 18, 22, 30}};
    vector<int> expected = {30, 30};
    ASSERT_EQ(SmallestRange().smallestRange(test_data), expected);
}

TEST(SmallestRangeTest, simple3) {
    vector<vector<int>> test_data = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
    vector<int> expected = {1, 1};
    ASSERT_EQ(SmallestRange().smallestRange(test_data), expected);
}

