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
// Created by Haibo Yan on 5/23/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/datastructure/LRU.h"

TEST(LRUTest, simple1) {
//    LRU<int,string> lru(5);
//
//    lru.put(1, "Tina");
//    lru.put(2, "Ruby");
//    lru.put(3, "Zachary");
//
//    ASSERT_EQ(lru.get(4), NULL);
//    ASSERT_EQ((*lru.get(3)), "Zachary");
//    ASSERT_EQ((*lru.get(2)), "Ruby");
//
//    lru.put(2, "Tristan");
//    ASSERT_EQ(lru.get(4), NULL);
//    ASSERT_EQ((*lru.get(1)), "Tina");
//    ASSERT_EQ((*lru.get(2)), "Tristan");
//    ASSERT_EQ((*lru.get(3)), "Zachary");
//
//    lru.put(4, "Haibo");
//    ASSERT_EQ((*lru.get(4)), "Haibo");
//    ASSERT_EQ((*lru.get(1)), "Tina");
//    ASSERT_EQ((*lru.get(2)), "Tristan");
//    ASSERT_EQ((*lru.get(3)), "Zachary");
//
//    ASSERT_EQ((*lru.get(1)), "Tina");
//    ASSERT_EQ((*lru.get(2)), "Tristan");
//    ASSERT_EQ((*lru.get(3)), "Zachary");
//    ASSERT_EQ((*lru.get(4)), "Haibo");
//
//    lru.put(5, "Ruby");
//    ASSERT_EQ((*lru.get(1)), "Tina");
//    ASSERT_EQ((*lru.get(2)), "Tristan");
//    ASSERT_EQ((*lru.get(3)), "Zachary");
//    ASSERT_EQ((*lru.get(4)), "Haibo");
//    lru.put(6, "Tony");
//
//    ASSERT_EQ((*lru.get(1)), "Tina");
//    ASSERT_EQ((*lru.get(2)), "Tristan");
//    ASSERT_EQ((*lru.get(3)), "Zachary");
//    ASSERT_EQ((*lru.get(4)), "Haibo");
//
//    ASSERT_EQ((*lru.get(6)), "Tony");
//    ASSERT_EQ(lru.get(5), NULL);
}

