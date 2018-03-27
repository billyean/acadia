//
// Created by haibo on 3/27/18.
//

#ifndef ALGORITHM_COIN_H
#define ALGORITHM_COIN_H

#include <vector>
#include <algorithm>

using namespace std;

class Coin {
public:
    Coin(vector<int>& coins): coins_(coins){
        sort(coins_.begin(), coins_.end());
    }

    int fewest(int);

    int combinations(int);
private:
    vector<int>& coins_;
};


#endif //ALGORITHM_COIN_H
