//
// Created by Haibo Yan on 4/20/18.
//

#include "PathSum.h"

int PathSum::pathSumIII(TreeNode<int>* root, int sum) {
    map<int, int> first;
    first[sum] = 1;

    return helper(root, first, sum);
}

int PathSum::helper(TreeNode<int>* root, map<int, int> pathm, int sum) {
    if (root == NULL) {
        return 0;
    }

    int v = 0;

    map<int, int> nextLevel;
    for (auto iter = pathm.begin(); iter != pathm.end(); iter++) {
        if (iter->first == root->value()) {
            v += iter->second;
        }
        nextLevel[iter->first - root->value()] = iter->second;
    }

    nextLevel[sum - root->value()] = nextLevel[sum - root->value()] + 1;

    v += helper(root->left(), nextLevel, sum) + helper(root->right(), nextLevel, sum);

    return v;
}
