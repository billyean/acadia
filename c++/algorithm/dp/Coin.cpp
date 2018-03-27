//
// Created by haibo on 3/27/18.
//

#include "Coin.h"
#include <climits>
#include <iostream>

int Coin::fewest(int amount) {
    int dp[amount + 1];

    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
        int x = INT_MAX;
        for (auto ci = coins_.begin(); ci != coins_.end(); ci++) {
            int c = *ci;

            if (i >= c) {
                x = min(x, dp[i - c] + 1);
            }
        }
        dp[i] = x;
    }

    return dp[amount];
}

int Coin::combinations(int amount) {
    int dp[amount + 1];

    for (int i = 0; i <= amount; i++) {
        dp[i] = 0;
    }

    for (auto ci = coins_.begin(); ci != coins_.end(); ci++) {
        int c = *ci;
        for (int i = 1; i <= amount; i++) {
            if(i == c) {
                dp[i]++;
            } else if (i > c) {
                dp[i] += dp[i - c];
            }
        }
    }

    return dp[amount];
}