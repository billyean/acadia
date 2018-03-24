//
// Created by haibo on 3/24/18.
//

#ifndef ALGORITHM_SMALLESTRANGE_H
#define ALGORITHM_SMALLESTRANGE_H

#include <vector>
#include <set>
#include <map>

using namespace std;

class SmallestRange {
public:
    vector<int> smallestRange(vector<vector<int>>&);
private:
    map<int, set<int>> merge(vector<vector<int>>&);
};


#endif //ALGORITHM_SMALLESTRANGE_H
