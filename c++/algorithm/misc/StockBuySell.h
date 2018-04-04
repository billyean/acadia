//
// Created by haibo on 3/19/18.
//

#ifndef ALGORITHM_STOCKBUYSELL_H
#define ALGORITHM_STOCKBUYSELL_H

#include <vector>

using namespace std;

class StockBuySell {
public:
    static int maxProfitI(vector<int>&);

    static int maxProfitII(vector<int>&);

    static int maxProfitIII(vector<int>&);

    static int maxProfitIV(vector<int>&, int);

    static int maxProfitWithCooldown(vector<int>&);

    static int maxProfitWithTransactionFee(vector<int>&, int);
};


#endif //ALGORITHM_STOCKBUYSELL_H
