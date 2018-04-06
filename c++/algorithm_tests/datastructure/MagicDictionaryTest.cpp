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
#include "../../algorithm/datastructure/MagicDictionary.h"

TEST(MagicDictionaryTest, simple1) {
    MagicDictionary md;

    md.buildDict({"hello", "leetcode"});

    ASSERT_FALSE(md.search("hello"));
    ASSERT_TRUE(md.search("hhllo"));
    ASSERT_FALSE(md.search("hell"));
    ASSERT_FALSE(md.search("leetcoded"));
}

TEST(MagicDictionaryTest, simple2) {
    MagicDictionary md;

    md.buildDict({"hello", "hallo", "leetcode"});

    ASSERT_TRUE(md.search("hello"));
    ASSERT_TRUE(md.search("hhllo"));
    ASSERT_FALSE(md.search("hell"));
    ASSERT_FALSE(md.search("leetcoded"));
}
