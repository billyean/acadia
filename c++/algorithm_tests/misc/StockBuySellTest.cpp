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

