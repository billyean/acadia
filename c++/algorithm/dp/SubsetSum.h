//
// Created by Haibo Yan on 4/1/18.
//

#ifndef ALGORITHM_SUBSETSUM_H
#define ALGORITHM_SUBSETSUM_H

#include <vector>

using namespace std;

class SubsetSum {
public:
    SubsetSum(vector<int>& number): numbers_(number){}

    vector<int> subsetToK(int);
private:
    vector<int>& numbers_;
};


#endif //ALGORITHM_SUBSETSUM_H
