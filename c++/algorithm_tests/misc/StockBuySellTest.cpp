//
// Created by Haibo Yan on 4/4/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/misc/StockBuySell.h"

TEST(StockBuySellTest, stockI1) {
    ASSERT_EQ(StockBuySell::maxProfitI({7, 1, 5, 3, 6, 4}), 5);
}

TEST(StockBuySellTest, stockI2) {
    ASSERT_EQ(StockBuySell::maxProfitI({7, 6, 4, 3, 1}), 0);
}

