//
// Created by Haibo Yan on 4/1/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/dp/SubsetSum.h"

TEST(SubsetSumTest, simple1) {
    vector<int> numbers = {1, 3, 4, 8, 10};
    SubsetSum ss(numbers);

    vector<int> subset = {3, 8};

    ASSERT_EQ(subset, ss.subsetToK(11));
}

TEST(SubsetSumTest, simple2) {
    vector<int> numbers = {1, 3, 4, 8, 10};
    SubsetSum ss(numbers);

    vector<int> subset = {1, 3, 10};

    ASSERT_EQ(subset, ss.subsetToK(14));
}

TEST(SubsetSumTest, simple3) {
    vector<int> numbers = {1, 3, 4, 8, 10};
    SubsetSum ss(numbers);

    vector<int> subset = {1, 3, 4, 8};

    ASSERT_EQ(subset, ss.subsetToK(16));
}

TEST(SubsetSumTest, simple4) {
    vector<int> numbers = {1, 3, 4, 8, 10};
    SubsetSum ss(numbers);

    vector<int> subset = {};

    ASSERT_EQ(subset, ss.subsetToK(20));
}
