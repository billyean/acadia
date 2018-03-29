//
// Created by haibo on 3/29/18.
//

#ifndef ALGORITHM_RANDOMIZEDSET_H
#define ALGORITHM_RANDOMIZEDSET_H
#include <map>
#include <vector>


using namespace std;

class RandomizedSet {
public:
    RandomizedSet(){}

    bool insert(int);

    bool remove(int);

    int getRandom();
private:
    map<int, int> one_map;

    vector<int> one_vec;
};


#endif //ALGORITHM_RANDOMIZEDSET_H
