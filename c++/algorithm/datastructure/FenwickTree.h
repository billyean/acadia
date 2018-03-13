//
// Created by Haibo Yan on 12/12/17.
//

#include <algorithm>
#include <vector>

using namespace std;

class FenwickTree {

public:
    FenwickTree(vector<int>&);

    void setNum(int, int);

    int rangeSum(int, int);

private:
    vector<int> _sum;

    int sum(int index);
};

