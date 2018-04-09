//
// Created by Haibo Yan on 4/6/18.
//

#include "Jump.h"

bool Jump::reachable(vector<int>& steps) {
    if (steps.size() < 2) {
        return true;
    }

    int max_step = steps[0];

    for (int i = 1; i < steps.size(); i++) {
        int v = steps[i];

        if (i > max_step) {
            return false;
        }
        max_step = max(max_step, i + v);
    }

    return true;
}