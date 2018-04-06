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
// Created by haibo on 3/27/18.
//

#include "gtest/gtest.h"
#include "../../algorithm/dp/Coin.h"

TEST(CoinTest, fewest1) {
    vector<int> coins = {1, 2, 5};
    Coin coin(coins);

    ASSERT_EQ(coin.fewest(5), 1);
}

TEST(CoinTest, fewest2) {
    vector<int> coins = {1, 2, 4};
    Coin coin(coins);

    ASSERT_EQ(coin.fewest(11), 4);
}

TEST(CoinTest, combination1) {
    vector<int> coins = {1, 2, 5};
    Coin coin(coins);

    ASSERT_EQ(coin.combinations(5), 4);
}

TEST(CoinTest, combination2) {
    vector<int> coins = {2};
    Coin coin(coins);

    ASSERT_EQ(coin.combinations(3), 0);
}

TEST(CoinTest, combination3) {
    vector<int> coins = {10};
    Coin coin(coins);

    ASSERT_EQ(coin.combinations(10), 1);
}

