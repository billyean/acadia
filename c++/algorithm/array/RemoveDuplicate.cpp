//
// Created by Haibo Yan on 3/13/18.
//

#include "RemoveDuplicate.h"
#include <map>


int RemoveDuplicate::removeDuplicates(vector<int>& nums) {
    int newLen = 0;

    if (nums.size() > 0) {
        int pos = 0;
        int current = nums[pos++];
        newLen = 1;

        while (pos < nums.size()) {
            if (nums[pos] != current) {
                nums[newLen++] = nums[pos];
                current = nums[pos];
            }
            pos++;
        }
    }
    return newLen;
}

int RemoveDuplicate::removeDuplicateAtMostTwice(vector<int>& nums) {
    int newLen = 0;
    map<int, int> dmap;

    for (int i = 0; i < nums.size(); i++) {
        int v = nums[i];

        if (dmap[v] < 2) {
            nums[newLen++] = v;
            dmap[v] += 1;
        }
    }
    return newLen;
}
