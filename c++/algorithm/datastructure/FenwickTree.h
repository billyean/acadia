//
// Created by Haibo Yan on 12/12/17.
//

#include <algorithm>
#include <vector>

using namespace std;

class FenwickTree {

public:
    FenwickTree(vector<int>& nums);

    void setNum(int index, int num);

    int rangeSum(int lower, int upper);

private:
    vector<int> _sum;

    int sum(int index);
};

