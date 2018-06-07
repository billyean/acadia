//
// Created by Haibo Yan on 6/6/18.
//

#ifndef ALGORITHM_WATERPOURING_H
#define ALGORITHM_WATERPOURING_H

#include <vector>

using namespace std;

class WaterPouring {
public:
    void printBar(vector<vector<char>> &);

    vector<vector<char>> bars(vector<int>&);

    vector<vector<char>> pouring(vector<int>&, vector<vector<char>>&, int, int);
};


#endif //ALGORITHM_WATERPOURING_H
