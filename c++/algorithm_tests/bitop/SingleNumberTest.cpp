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

#include "gtest/gtest.h"
#include "../../algorithm/bitop/SingleNumber.h"

TEST(SingleNUmberTest, inTwos1) {
    vector<int> test_data = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5};
    SingleNumber sn(test_data);
    ASSERT_EQ(sn.findInTwos(), 6);
}

TEST(SingleNUmberTest, inTwos2) {
    vector<int> test_data = {6};
    SingleNumber sn(test_data);
    ASSERT_EQ(sn.findInTwos(), 6);
}

TEST(SingleNUmberTest, inThrees1) {
    vector<int> test_data = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
    SingleNumber sn(test_data);
    ASSERT_EQ(sn.findInThrees(), 6);
}

TEST(SingleNUmberTest, inThrees2) {
    vector<int> test_data = {6};
    SingleNumber sn(test_data);
    ASSERT_EQ(sn.findInThrees(), 6);
}

TEST(SingleNUmberTest, inFours1) {
    vector<int> test_data = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
    SingleNumber sn(test_data);
    ASSERT_EQ(sn.findInFours(), 6);
}

TEST(SingleNUmberTest, inFours2) {
    vector<int> test_data = {6};
    SingleNumber sn(test_data);
    ASSERT_EQ(sn.findInFours(), 6);
}

