//
// Created by Haibo Yan on 4/4/18.
//

#include "ProductLessThanK.h"

int ProductLessThanK::numbers(vector<int>& nums, int k) {
    int n = 0;
    long product = 1, left = -1;

    for (int i = 0; i < nums.size(); i++) {
        product *= nums[i];
        while (left < i && product > k) {
            product /= nums[++left];
        }
        n++;
    }

    return n;
}