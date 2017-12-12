//
// Created by Haibo Yan on 12/12/17.
//

#include "gtest/gtest.h"
#include "../../algorithm/datastructure/FenwickTree.h"

TEST(FenwickTreeTest, PositiveNos) {
    vector<int> nums;

    for (int i = 0; i < 100; i++) {
        nums.push_back(i + 1);
    }
    FenwickTree ft(nums);

    ASSERT_EQ (ft.rangeSum(0, 9), 55);
}
