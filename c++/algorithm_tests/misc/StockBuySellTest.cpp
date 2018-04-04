//
// Created by Haibo Yan on 4/4/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/misc/StockBuySell.h"

TEST(StockBuySellTest, stockI1) {
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    ASSERT_EQ(StockBuySell::maxProfitI(prices), 5);
}

TEST(StockBuySellTest, stockI2) {
    vector<int> prices = {7, 6, 4, 3, 1};
    ASSERT_EQ(StockBuySell::maxProfitI(prices), 0);
}

TEST(StockBuySellTest, stockII1) {
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    ASSERT_EQ(StockBuySell::maxProfitII(prices), 7);
}

TEST(StockBuySellTest, stockII2) {
    vector<int> prices = {7, 6, 4, 3, 1};
    ASSERT_EQ(StockBuySell::maxProfitII(prices), 0);
}

TEST(StockBuySellTest, stockIII1) {
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    ASSERT_EQ(StockBuySell::maxProfitIII(prices), 7);
}

TEST(StockBuySellTest, stockIII2) {
    vector<int> prices = {7, 6, 4, 3, 1};
    ASSERT_EQ(StockBuySell::maxProfitIII(prices), 0);
}

TEST(StockBuySellTest, stockIII3) {
    vector<int> prices = {1, 2};
    ASSERT_EQ(StockBuySell::maxProfitIII(prices), 1);
}

