//
// Created by haibo on 3/28/18.
//

#ifndef ALGORITHM_MAXCHUNKS_H
#define ALGORITHM_MAXCHUNKS_H

#include <vector>

using namespace std;

class MaxChunks {
public:
    MaxChunks(vector<int>& arr_): arr(arr_){}

    int maxChunksToSorted();
private:
    vector<int>& arr;
};


#endif //ALGORITHM_MAXCHUNKS_H
