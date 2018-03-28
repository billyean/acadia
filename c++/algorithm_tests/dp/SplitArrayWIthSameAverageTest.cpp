//
// Created by haibo on 3/24/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/dp/SplitArrayWIthSameAverage.h"


TEST(SplitArrayWIthSameAverageTest, NegativeLongTime) {
    SplitArrayWIthSameAverage s;
    vector<int> test_data = {33,86,88,78,21,76,19,20,88,76,10,25,37,97,58,89,65,59,98,57,50,30,58,5,61,72,23,6};
    ASSERT_FALSE(s.splitArraySameAverage(test_data));
}

TEST(SplitArrayWIthSameAverageTest, DPNegativeLongTime) {
    SplitArrayWIthSameAverage s;
    vector<int> test_data = {33,86,88,78,21,76,19,20,88,76,10,25,37,97,58,89,65,59,98,57,50,30,58,5,61,72,23,6};
    ASSERT_FALSE(s.splitArraySameAverageDP(test_data));
}

TEST(SplitArrayWIthSameAverageTest, DPNegativeShortTime) {
    SplitArrayWIthSameAverage s;
    vector<int> test_data = {3, 1};
    ASSERT_FALSE(s.splitArraySameAverageDP(test_data));
}


TEST(SplitArrayWIthSameAverageTest, DPPositiveShortTime) {
    SplitArrayWIthSameAverage s;
    vector<int> test_data = {1,2,3,4,5,6,7,8};
    ASSERT_TRUE(s.splitArraySameAverageDP(test_data));
}
