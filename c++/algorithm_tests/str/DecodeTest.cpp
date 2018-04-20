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
// Created by Haibo Yan on 4/20/18.
//


#include "gtest/gtest.h"
#include "../../algorithm/str/Decode.h"

TEST(DecodeTest, decode_1) {
    ASSERT_EQ(Decode::decodeString("3[a]2[bc]"), "aaabcbc");
}

TEST(DecodeTest, decode_2) {
    ASSERT_EQ(Decode::decodeString("3[a2[c]]"), "accaccacc");
}

TEST(DecodeTest, decode_3) {
    ASSERT_EQ(Decode::decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef");
}

TEST(DecodeTest, decode_4) {
    ASSERT_EQ(Decode::decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"), "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");
}

