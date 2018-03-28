//
// Created by haibo on 3/24/18.
//

#ifndef ALGORITHM_SPLITARRAYWITHSAMEAVERAGE_H
#define ALGORITHM_SPLITARRAYWITHSAMEAVERAGE_H

#include <vector>

using namespace std;

class SplitArrayWIthSameAverage {
public:
    bool splitArraySameAverage(vector<int>&);

    bool splitArraySameAverageDP(vector<int>&);
private:
    bool splitArraySameAverageWithK(vector<int>&, int, int, int,  int);
};


#endif //ALGORITHM_SPLITARRAYWITHSAMEAVERAGE_H
