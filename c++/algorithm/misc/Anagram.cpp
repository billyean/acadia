//
// Created by haibo on 3/16/18.
//

#include "Anagram.h"

#include <map>

bool Anagram::is_anagram(string s1, string s2) {
    int s1c[256], s2c[256];

    for (auto i = 0; i < s1.length(); i++) {
        s1c[s1[i]]++;
    }

    for (auto i = 0; i < s2.length(); i++) {
        s2c[s2[i]]++;
    }

    for (int i = 0; i < 256; i++) {
        if (s1c[i] != s2c[i]) {
            return false;
        }
    }

    return true;
}