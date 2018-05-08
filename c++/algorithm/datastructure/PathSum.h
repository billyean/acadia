//
// Created by Haibo Yan on 4/20/18.
//

#ifndef ALGORITHM_PATHSUM_H
#define ALGORITHM_PATHSUM_H

#include "TreeNode.h"
#include <map>

using namespace std;

class PathSum {
public:
    int pathSumIII(TreeNode<int>*, int);
private:
    int helper(TreeNode<int>*, map<int, int>, int);
};


#endif //ALGORITHM_PATHSUM_H
