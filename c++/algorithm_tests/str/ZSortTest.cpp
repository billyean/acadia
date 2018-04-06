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
#include "../../algorithm/str/ZSort.h"

TEST(ZSortTest, zsort1) {
    vector<string> v = {"Cow", "Chicken", "Deer", "Rabbit"};
    ZSort::zsort(v, 3);
    ASSERT_EQ(vector<string>({"Rabbit", "Deer", "Chicken", "Cow"}), v);
}

TEST(ZSortTest, zsort2) {
    vector<string> v = {"Cow", "Chbcken", "Deer", "Rabbit"};
    ZSort::zsort(v, 4);
    ASSERT_EQ(vector<string>({"Rabbit", "Chbcken", "Deer","Cow"}), v);
}

TEST(ZSortTest, zsort3) {
    vector<string> v = {};
    ZSort::zsort(v, 3);
    ASSERT_EQ(vector<string>(), v);
}