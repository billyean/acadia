//
// Created by haibo on 3/27/18.
//

#ifndef ALGORITHM_SUBSEQUENCE_H
#define ALGORITHM_SUBSEQUENCE_H

#include <vector>

using namespace std;

class SubSequence {
public:
    SubSequence(vector<int>& sequence): nums(sequence){}

    vector<int> longestCommon(vector<int>& other);

    vector<int> longestIncreasing();

    int wiggleMaxLength();
private:
    vector<int>& nums;
};


#endif //ALGORITHM_SUBSEQUENCE_H
