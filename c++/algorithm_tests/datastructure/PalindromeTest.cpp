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
// Created by Haibo Yan on 4/10/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/datastructure/Palindrome.h"


TEST(PalindromeTest, number_positive_0) {
    ASSERT_TRUE(Palindrome::palindromeNumber(101));
}

TEST(PalindromeTest, number_positive_1) {
    ASSERT_TRUE(Palindrome::palindromeNumber(1001));
}

TEST(PalindromeTest, number_negative_0) {
    ASSERT_FALSE(Palindrome::palindromeNumber(100));
}

TEST(PalindromeTest, number_negative_1) {
    ASSERT_FALSE(Palindrome::palindromeNumber(10011));
}

TEST(PalindromeTest, valid_positive) {
    ASSERT_TRUE(Palindrome::valid("Red rum, sir, is murder"));
}

TEST(PalindromeTest, valid_negative) {
    ASSERT_FALSE(Palindrome::valid("Programcreek is awesome"));
}

