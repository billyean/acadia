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

