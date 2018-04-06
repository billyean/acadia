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
#include "../../algorithm/bitop/BitUtilities.h"

TEST(BitUtilitiesTest, swap1) {
    int one = 1;
    int two = 2;
    int *v1 = &one;
    int *v2 = &two;

    BitUtilities::swap(v1, v2);

    ASSERT_EQ(*v1, 2);
    ASSERT_EQ(*v2, 1);
}

TEST(BitUtilitiesTest, power2) {
    ASSERT_TRUE(BitUtilities::powerOfTwo(1));
    ASSERT_TRUE(BitUtilities::powerOfTwo(2));
    ASSERT_FALSE(BitUtilities::powerOfTwo(3));
    ASSERT_TRUE(BitUtilities::powerOfTwo(4));
    ASSERT_FALSE(BitUtilities::powerOfTwo(5));
    ASSERT_FALSE(BitUtilities::powerOfTwo(6));
    ASSERT_FALSE(BitUtilities::powerOfTwo(7));
    ASSERT_TRUE(BitUtilities::powerOfTwo(8));
    ASSERT_FALSE(BitUtilities::powerOfTwo(9));
    ASSERT_FALSE(BitUtilities::powerOfTwo(10));
    ASSERT_FALSE(BitUtilities::powerOfTwo(11));
    ASSERT_FALSE(BitUtilities::powerOfTwo(12));
    ASSERT_FALSE(BitUtilities::powerOfTwo(13));
    ASSERT_FALSE(BitUtilities::powerOfTwo(14));
    ASSERT_FALSE(BitUtilities::powerOfTwo(15));
    ASSERT_TRUE(BitUtilities::powerOfTwo(16));
}

TEST(BitUtilitiesTest, power4) {
    ASSERT_TRUE(BitUtilities::powerOfFour(1));
    ASSERT_FALSE(BitUtilities::powerOfFour(2));
    ASSERT_FALSE(BitUtilities::powerOfFour(3));
    ASSERT_TRUE(BitUtilities::powerOfFour(4));
    ASSERT_FALSE(BitUtilities::powerOfFour(5));
    ASSERT_FALSE(BitUtilities::powerOfFour(6));
    ASSERT_FALSE(BitUtilities::powerOfFour(7));
    ASSERT_FALSE(BitUtilities::powerOfFour(8));
    ASSERT_FALSE(BitUtilities::powerOfFour(9));
    ASSERT_FALSE(BitUtilities::powerOfFour(10));
    ASSERT_FALSE(BitUtilities::powerOfFour(11));
    ASSERT_FALSE(BitUtilities::powerOfFour(12));
    ASSERT_FALSE(BitUtilities::powerOfFour(13));
    ASSERT_FALSE(BitUtilities::powerOfFour(14));
    ASSERT_FALSE(BitUtilities::powerOfFour(15));
    ASSERT_TRUE(BitUtilities::powerOfFour(16));
}

