//
// Created by haibo on 3/27/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/dp/Knapsack.h"

TEST(KnapsackTest, simple1) {
    vector<tuple<int, int>> items = {
            {1, 1},
            {3, 4},
            {4, 5},
            {5, 7}
    };

    Knapsack ks(items);
    ASSERT_EQ(ks.valuable(7), 9);
}
