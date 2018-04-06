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

