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
#include "../../algorithm/matrix/Islands.h"

TEST(IslandsTest, simple1) {
    vector<vector<char>> test_matrix = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
    };

    Islands il(test_matrix);

    ASSERT_EQ(il.size(), 1);
}

TEST(IslandsTest, simple2) {
    vector<vector<char>> test_matrix = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
    };

    Islands il(test_matrix);

    ASSERT_EQ(il.size(), 3);
}

TEST(IslandsTest, simple3) {
    vector<vector<char>> test_matrix = {
            {'1','0','0','0'},
            {'0','1','0','0'},
            {'0','0','1','0'},
            {'0','0','0','1'}
    };

    Islands il(test_matrix);

    ASSERT_EQ(il.size(), 4);
}

TEST(IslandsTest, simple4) {
    vector<vector<char>> test_matrix = {};

    Islands il(test_matrix);

    ASSERT_EQ(il.size(), 0);
}

