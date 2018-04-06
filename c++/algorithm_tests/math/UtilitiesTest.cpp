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
// Created by haibo on 3/16/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/math/Utilities.h"

TEST(UtilitiesTest, add_one_1) {
    vector<int> expected = {1, 2, 3, 4, 6};
    vector<int> opr = {1, 2, 3, 4, 5};
    ASSERT_EQ(expected, Utilities::add_one(opr));
}

TEST(UtilitiesTest, add_one_2)  {
    vector<int> expected = {2, 0, 0, 0};
    vector<int> opr = {1, 9, 9, 9};
    ASSERT_EQ(expected, Utilities::add_one(opr));
}

TEST(UtilitiesTest, add_one_3)  {
    vector<int> expected = {1, 0, 0, 0, 0};
    vector<int> opr = {9, 9, 9, 9};
    ASSERT_EQ(expected, Utilities::add_one(opr));
}

TEST(UtilitiesTest, sort_by_one_1) {
    vector<int> expected = {1, 2, 4, 3, 5};
    vector<int> opr = {1, 2, 3, 4, 5};
    Utilities::sort_by_one_bits(opr);
    ASSERT_EQ(expected, opr);
}

TEST(UtilitiesTest, sort_by_one_2) {
    vector<int> expected = {1, 2, 3, -2, -3, -1};
    vector<int> opr = {1, -1, 2, - 2, 3, -3};
    Utilities::sort_by_one_bits(opr);
    ASSERT_EQ(expected, opr);
}

TEST(UtilitiesTest, sort_by_one_3) {
    vector<int> expected = {};
    vector<int> opr = {};
    Utilities::sort_by_one_bits(opr);
    ASSERT_EQ(expected, opr);
}

TEST(UtilitiesTest, reverse_1) {
    ASSERT_EQ(54321, Utilities::reverse(12345));
}

TEST(UtilitiesTest, reverse_2) {
    ASSERT_EQ(4321, Utilities::reverse(1234));
}

TEST(UtilitiesTest, reverse_3) {
    ASSERT_EQ(1, Utilities::reverse(1));
}

TEST(UtilitiesTest, reverse_4) {
    ASSERT_EQ(0, Utilities::reverse(0));
}

TEST(UtilitiesTest, atoi_1) {
    ASSERT_EQ(98, Utilities::atoi("0x62"));
}

TEST(UtilitiesTest, atoi_2) {
    ASSERT_EQ(50, Utilities::atoi("062"));
}

TEST(UtilitiesTest, atoi_3) {
    ASSERT_EQ(12, Utilities::atoi("+12"));
}

TEST(UtilitiesTest, atoi_4) {
    ASSERT_EQ(-12, Utilities::atoi("-12"));
}

TEST(UtilitiesTest, atoi_5) {
    ASSERT_EQ(13, Utilities::atoi("13"));
}

TEST(UtilitiesTest, atoi_6) {
    ASSERT_EQ(1706, Utilities::atoi("0x6aa"));
}

TEST(UtilitiesTest, nth_ugly_1) {
    ASSERT_EQ(8, Utilities::nth_ugly(7));
}

TEST(UtilitiesTest, nth_ugly_2) {
    ASSERT_EQ(12, Utilities::nth_ugly(10));
}

TEST(UtilitiesTest, nth_ugly_3) {
    ASSERT_EQ(24, Utilities::nth_ugly(15));
}

TEST(UtilitiesTest, nth_ugly_4) {
    ASSERT_EQ(5832, Utilities::nth_ugly(150));
}

TEST(UtilitiesTest, add_1) {
    vector<int> a1 = {4};
    vector<int> a2 = {5};
    vector<int> sum = vector<int>{9};
    ASSERT_EQ(sum, Utilities::add(a1,a2));
}

TEST(UtilitiesTest, add_2) {
    vector<int> a1 = {2, 4, 3};
    vector<int> a2 = {5, 6, 4};
    vector<int> sum = vector<int>{7, 0, 8};
    ASSERT_EQ(sum, Utilities::add(a1,a2));
}

TEST(UtilitiesTest, add_3) {
    vector<int> a1 = {7, 2, 4, 3};
    vector<int> a2 = {5, 6, 4};
    vector<int> sum = vector<int>{2, 9, 8, 3};
    ASSERT_EQ(sum, Utilities::add(a1,a2));
}

TEST(UtilitiesTest, add_4) {
    vector<int> a1 = {9, 9, 9, 9, 5, 3, 1};
    vector<int> a2 = {2, 4, 7, 2};
    vector<int> sum = vector<int>{1, 4, 7, 2, 6, 3, 1};
    ASSERT_EQ(sum, Utilities::add(a1,a2));
}


