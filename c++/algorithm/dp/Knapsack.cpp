//
// Created by haibo on 3/27/18.
//

#include "Knapsack.h"
#include <climits>

using namespace std;

int Knapsack::valuable(int total) {
    int dp[total + 1];
    fill_n(dp, total + 1, 0);

    for (int i = 1; i <= total; i++) {
        int m = INT_MIN;

        for (auto ii = items_.begin(); ii != items_.end(); ii++) {
            int w = get<0>(*ii);
            int v = get<1>(*ii);

            if (w <= i) {
                m = max(m, dp[i - w] + v);
            }

        }
        dp[i] = m;
    }

    return dp[total];
}