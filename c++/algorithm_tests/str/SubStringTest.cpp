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
// Created by Haibo Yan on 5/22/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/str/SubString.h"

TEST(SubStringTest, longestNoRepeated) {
    ASSERT_EQ(SubString::longestNoRepeated(""), "");
    ASSERT_EQ(SubString::longestNoRepeated("ab"), "ab");
    ASSERT_EQ(SubString::longestNoRepeated("abcabcbb"), "abc");
    ASSERT_EQ(SubString::longestNoRepeated("bbbbb"), "b");
    ASSERT_EQ(SubString::longestNoRepeated("pwwkew"), "wke");
}



TEST(SubStringTest, longestCommons) {
    ASSERT_EQ(SubString::longestCommon("", "abc"), "");
    ASSERT_EQ(SubString::longestCommon("def", "abc"), "");
    ASSERT_EQ(SubString::longestCommon("123", "345"), "3");
    ASSERT_EQ(SubString::longestCommon("12345", "34567"), "345");
}

