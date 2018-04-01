//
// Created by Haibo Yan on 3/31/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/str/Amazon.h"

TEST(AmazonTest, mostFrequent1) {
    string sentence = "jack and jill went to the market to buy bread and cheese. cheese is jack's and jill's favorite food.";
    vector<string> excluded = {"and", "he", "the", "to", "is"};
    vector<string> expected = {"cheese", "jack", "jill", "s"};
    ASSERT_EQ(expected, Amazon::retrieveMostFrequentlyUsedWords(sentence, excluded));
}

TEST(AmazonTest, mostFrequent2) {
    string sentence = "Rose is a flower red rose are flower";
    vector<string> excluded = {"is", "are", "a"};
    vector<string> expected = {"flower", "rose"};
    ASSERT_EQ(expected, Amazon::retrieveMostFrequentlyUsedWords(sentence, excluded));
}

TEST(AmazonTest, mostFrequent3) {
    string sentence = "I am Tristan";
    vector<string> excluded = {"I"};
    vector<string> expected = {"am", "tristan"};
    ASSERT_EQ(expected, Amazon::retrieveMostFrequentlyUsedWords(sentence, excluded));
}

TEST(AmazonTest, mostFrequent4) {
    string sentence = "I'm Tristan, Tristan is a super hero";
    vector<string> excluded = {"m"};
    vector<string> expected = {"tristan"};
    ASSERT_EQ(expected, Amazon::retrieveMostFrequentlyUsedWords(sentence, excluded));
}

TEST(AmazonTest, reorderLines1) {
    vector<string> lines = {"f4 12", "t1 l3 a2", "r1 box", "b4 xi", "br8 eat", "w1 has", "f3 52"};
    vector<string> expected = {"r1 box", "br8 eat", "w1 has", "t1 l3 a2", "b4 xi", "f4 12", "f3 52"};
    ASSERT_EQ(expected, Amazon::reorderLines(lines.size(), lines));
}

TEST(AmazonTest, reorderLines2) {
    vector<string> lines = {"a1 9 2 3 1", "g1 act car",  "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
    vector<string> expected = {"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"};
    ASSERT_EQ(expected, Amazon::reorderLines(lines.size(), lines));
}

TEST(AmazonTest, reorderLines3) {
    vector<string> lines = {"mi2 jog mid pet", "wz3 34 54 398",  "a1 alps cow bar", "x4 45 21 7"};
    vector<string> expected = {"a1 alps cow bar", "mi2 jog mid pet", "wz3 34 54 398", "x4 45 21 7"};
    ASSERT_EQ(expected, Amazon::reorderLines(lines.size(), lines));
}

TEST(AmazonTest, reorderLines4) {
    vector<string> lines = {"t2 13 121 98", "r1 box ape bit",  "b4 xi me nu", "br8 eat nim did", "w1 has uni gry", "f3 52 54 31"};
    vector<string> expected = {"r1 box ape bit", "br8 eat nim did", "w1 has uni gry",  "b4 xi me nu", "t2 13 121 98", "f3 52 54 31"};
    ASSERT_EQ(expected, Amazon::reorderLines(lines.size(), lines));
}

