//
// Created by haibo on 3/19/18.
//

#include "StockBuySell.h"

int StockBuySell::maxProfitI(vector<int> prices) {
    int maxProfit = 0;

    if (prices.size() > 1) {
        int minPrice = prices[0];

        for (int i = 1; i < prices.size(); i++) {
            maxProfit = max(maxProfit, prices[i] - minPrice);
            minPrice = min(minPrice, prices[i]);
        }
    }

    return maxProfit;
}

int StockBuySell::maxProfitII(vector<int> prices) {
    int maxProfit = 0;

    if (prices.size() > 0) {
        int minPrice = prices[0];

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
    }

    return maxProfit;
}

int StockBuySell::maxProfitIII(vector<int> prices) {
    int maxProfit = 0;

    if (prices.size() > 0) {
        int lastIndex = prices.size() - 1;
        int left[prices.size()], right[prices.size()];
        int minLeft = left[0] = 0;
        int minRight = right[lastIndex] = 0;

        for (int i = 1; i < prices.size(); i++) {
            left[i] = max(left[i - 1], prices[i] - minLeft);
            minLeft = min(minLeft, prices[i]);

            right[lastIndex - i] = max(right[lastIndex - i], prices[i] - minRight);
            minRight = min(minRight, prices[lastIndex - i]);
        }

        for (int i = 0; i < prices.size(); i++) {
            maxProfit = max(maxProfit, left[i] + right[i]);
        }
    }

    return maxProfit;
}

int StockBuySell::maxProfitIV(vector<int>) {

}