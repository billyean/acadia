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
// Created by haibo on 3/29/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/datastructure/RandomizedSet.h"

TEST(RandomizedSetTest, test1) {
    RandomizedSet set;

    ASSERT_TRUE(set.insert(1));
    ASSERT_FALSE(set.remove(2));
    ASSERT_TRUE(set.insert(2));

    set.getRandom();
    ASSERT_TRUE(set.remove(1));
    ASSERT_FALSE(set.insert(2));
    ASSERT_EQ(set.getRandom(), 2);
}

//TEST(RandomizedSetTest, test2) {
//    RandomizedSet set;
//
//    ASSERT_TRUE(set.insert(1));
//    ASSERT_FALSE(set.remove(2));
//    ASSERT_TRUE(set.insert(2));
//
//    set.getRandom();
//    ASSERT_TRUE(set.remove(1));
//    ASSERT_FALSE(set.insert(2));
//    ASSERT_EQ(set.getRandom(), 2);
//}