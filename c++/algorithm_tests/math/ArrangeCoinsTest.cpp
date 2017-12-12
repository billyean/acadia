//
// Created by Haibo Yan on 12/12/17.
//

#include "gtest/gtest.h"
#include "../../algorithm/math/ArrangeCoins.h"

TEST(ArrangeCoinsTest, PositiveNos) {
    ArrangeCoins ac;

    ASSERT_EQ (ac.arrangeCoins(5), 2);
    ASSERT_EQ (ac.arrangeCoins(8), 3);
    ASSERT_EQ (ac.arrangeCoins(6), 3);
    ASSERT_EQ (ac.arrangeCoins(1804289383), 60070);
}
