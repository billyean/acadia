//
// Created by haibo on 3/24/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/range/SmallestRange.h"

//TEST(SmallestRangeTest, simple) {
//    vector<vector<int>> test_data = {{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}};
//    vector<int> expected = {20, 24};
//    ASSERT_EQ(SmallestRange().smallestRange(test_data), expected);
//}
//
//TEST(SmallestRangeTest, simple2) {
//    vector<vector<int>> test_data = {{4, 10, 15, 24, 26, 30}, {0, 9, 12, 20, 30}, {5, 18, 22, 30}};
//    vector<int> expected = {30, 30};
//    ASSERT_EQ(SmallestRange().smallestRange(test_data), expected);
//}

TEST(SmallestRangeTest, simple3) {
    vector<vector<int>> test_data = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
    vector<int> expected = {1, 1};
    ASSERT_EQ(SmallestRange().smallestRange(test_data), expected);
}

