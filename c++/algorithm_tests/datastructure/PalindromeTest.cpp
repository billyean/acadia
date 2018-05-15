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
    ASSERT_TRUE(Palindrome::palindrome_number1(101));
}

TEST(PalindromeTest, number_positive_1) {
    ASSERT_TRUE(Palindrome::palindrome_number1(1001));
}

TEST(PalindromeTest, number_negative_0) {
    ASSERT_FALSE(Palindrome::palindrome_number1(100));
}

TEST(PalindromeTest, number_negative_1) {
    ASSERT_FALSE(Palindrome::palindrome_number1(10011));
}

TEST(PalindromeTest, valid_positive) {
    ASSERT_TRUE(Palindrome::valid("Red rum, sir, is murder"));
}

TEST(PalindromeTest, valid_negative) {
    ASSERT_FALSE(Palindrome::valid("Programcreek is awesome"));
}

# define ASSERT_EQ_WITOUT_ORDER(expression1, expression2)  if (true) {\
    auto _actual = expression1; \
    auto _expected = expression2; \
    sort(_actual.begin(), _actual.end()); \
    sort(_expected.begin(), _expected.end()); \
    ASSERT_EQ(_actual, _expected); }


TEST(PalindromeTest, palindrome_number2) {
    ASSERT_TRUE(Palindrome::palindrome_number2(0));
    ASSERT_TRUE(Palindrome::palindrome_number2(3));
    ASSERT_FALSE(Palindrome::palindrome_number2(4));
    ASSERT_FALSE(Palindrome::palindrome_number2(6));
    ASSERT_FALSE(Palindrome::palindrome_number2(0b11001));
    ASSERT_TRUE(Palindrome::palindrome_number2(0b10101));
    ASSERT_TRUE(Palindrome::palindrome_number2(0b1001));
    ASSERT_TRUE(Palindrome::palindrome_number2(0b10001));
}

TEST(PalindromeTest, palindrome_number1) {
    ASSERT_TRUE(Palindrome::palindrome_number1(11));
}

TEST(PalindromeTest, longestPalindrome0) {
    ASSERT_EQ(Palindrome::longestPalindrome("abccccdd"), 7);
    ASSERT_EQ(Palindrome::longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"), 983);
}

TEST(PalindromeTest, palindromePairs0) {
    vector<string> words = {"bat", "tab", "cat"};
    vector<vector<int>> expected = {{0, 1}, {1, 0}};
    ASSERT_EQ_WITOUT_ORDER(Palindrome::palindromePairs(words), expected);
}

TEST(PalindromeTest, palindromePairs1) {
    vector<string> words = {"abcd", "dcba", "lls", "s", "sssll"};
    vector<vector<int>> expected = {{0, 1}, {1, 0}, {3, 2}, {2, 4}};
    ASSERT_EQ_WITOUT_ORDER(Palindrome::palindromePairs(words), expected);
}

TEST(PalindromeTest, palindromePairs2) {
    vector<string> words = {"a", ""};
    vector<vector<int>> expected = {{0, 1}, {1, 0}};
    ASSERT_EQ_WITOUT_ORDER(Palindrome::palindromePairs(words), expected);
}

TEST(PalindromeTest, palindromePairs3) {
    vector<string> words = {"a","abc","aba",""};
    vector<vector<int>> expected = {{0, 3}, {3, 0}, {2, 3}, {3, 2}};
    ASSERT_EQ_WITOUT_ORDER(Palindrome::palindromePairs(words), expected);
}

TEST(PalindromeTest, palindromePairs4) {
    vector<string> words = {"a","b","c","ab","ac","aa"};
    vector<vector<int>> expected = {{3, 0}, {1, 3}, {4, 0}, {2, 4}, {5, 0}, {0, 5}};
    ASSERT_EQ_WITOUT_ORDER(Palindrome::palindromePairs(words), expected);
}

TEST(PalindromeTest, palindromePairs5) {
    vector<string> words = {"ab","ba","abc","cba"};
    vector<vector<int>> expected = {{0, 1}, {1, 0}, {2, 1}, {2, 3}, {0, 3}, {3, 2}};
    ASSERT_EQ_WITOUT_ORDER(Palindrome::palindromePairs(words), expected);
}

TEST(PalindromeTest, shortestPalindrome1) {
    ASSERT_EQ(Palindrome::shortestPalindrome("cacacabc"), "cbacacacabc");
    ASSERT_EQ(Palindrome::shortestPalindrome("ab"), "bab");
    ASSERT_EQ(Palindrome::shortestPalindrome(""), "");
}
