//
// Created by haibo on 3/16/18.
//

#include "RemoveLetters.h"

#include <deque>
#include <iostream>

string RemoveLetters::remove(string word) {
    deque<char> d = {};
    int cn[256];
    bool in_queue[256];

    // I was surprised that C++ is not initialized the array with default value.
    // At least in my ubuntu 16.04, it doesn't initiate in_queue
    for (int i = 0 ; i < 256; i++) {
        cn[i] = 0;
        in_queue[i] = false;
    }

    for (int i = 0; i < word.length(); i++) {
        cn[word[i]]++;
    }

    for (int i = 0; i < word.length(); i++) {
        char c = word[i];
        cn[c]--;

        if (in_queue[c]) {
            continue;
        }

        while (d.begin() != d.end() && d.back() > c && cn[d.back()] > 0) {
            in_queue[d.back()] = false;
            d.pop_back();
        }
        in_queue[c] = true;
        d.push_back(c);
    }

    string r = "";

    for (auto i = d.begin(); i != d.end(); i++) {
        r += (*i);
    }

    return r;
}