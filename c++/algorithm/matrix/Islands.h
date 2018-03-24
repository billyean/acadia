//
// Created by haibo on 3/24/18.
//

#ifndef ALGORITHM_ISLANDS_H
#define ALGORITHM_ISLANDS_H

#include <vector>
#include <iostream>

using namespace std;

class Islands {
public:
    Islands(vector<vector<char>>& matrix_): matrix(matrix_){}

    int size();
private:
    vector<vector<char>>& matrix;

    void dfs(int, int, char, char, char);
};


#endif //ALGORITHM_ISLANDS_H
