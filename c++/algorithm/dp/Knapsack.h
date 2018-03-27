//
// Created by haibo on 3/27/18.
//

#ifndef ALGORITHM_KNAPSACK_H
#define ALGORITHM_KNAPSACK_H

#include <vector>
#include <tuple>

using namespace std;

class Knapsack {
public:
    Knapsack(vector<tuple<int, int>>& items): items_(items){}

    int valuable(int);
private:
    vector<tuple<int, int>>& items_;
};


#endif //ALGORITHM_KNAPSACK_H
