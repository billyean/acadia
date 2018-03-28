//
// Created by haibo on 3/28/18.
//

#ifndef ALGORITHM_SINGLENUMBER_H
#define ALGORITHM_SINGLENUMBER_H

#include <vector>

using namespace std;

class SingleNumber {
public:
    SingleNumber(vector<int>& nums): nums_(nums){}

    int findInTwos();

    int findInThrees();

    int findInFours();
private:
    vector<int>& nums_;
};


#endif //ALGORITHM_SINGLENUMBER_H
