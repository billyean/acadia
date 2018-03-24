//
// Created by haibo on 3/24/18.
//

#include "MagicDictionary.h"
#include <algorithm>

void MagicDictionary::buildDict(vector<string> dict) {
    dict_ = dict;
    sort(dict_.begin(), dict_.end());
}

bool MagicDictionary::search(string word) {
    auto l = lower_bound(dict_.begin(), dict_.end(), word);
    auto u = upper_bound(dict_.begin(), dict_.end(), word);


    for (auto iter = prev(l); iter != u; iter++) {
        if (diff(*iter, word) == 1) {
            return true;
        }
    }

    return false;
}

int MagicDictionary::diff(string s1, string s2) {
    if (s1.size() != s2.size()) return -1;

    int diff = 0;

    for (int i = 0; i < s1.size(); i++) {
        if (s1[i] != s2[i]) {
            diff++;
        }
    }

    return diff;
}