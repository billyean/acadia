//
// Created by haibo on 3/28/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/str/TopKFrequentWords.h"

TEST(TopKFrequentWordsTest, test1) {
    vector<string> test_data = {"i", "love", "leetcode", "i", "love", "coding"};
    vector<string> expected_result = {"i", "love"};
    ASSERT_EQ(TopKFrequentWords::topKFrequent(test_data, 2), expected_result);
}

TEST(TopKFrequentWordsTest, test2) {
    vector<string> test_data = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    vector<string> expected_result = {"the", "is", "sunny", "day"};
    ASSERT_EQ(TopKFrequentWords::topKFrequent(test_data, 4), expected_result);
}

