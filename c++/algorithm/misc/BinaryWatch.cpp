//
// Created by haibo on 3/14/18.
//

#include "BinaryWatch.h"
#include <sstream>

int BinaryWatch::bits(int h, int m) {
    auto b = 0;

    while (h > 0) {
        h -= h & -h;
        b++;
    }

    while (m > 0) {
        m -= m & -m;
        b++;
    }

    return b;
}

string BinaryWatch::time(int h, int m) {
    char out[6];

    snprintf(out, 6, "%d:%02d", h, m);
    return string(out);
}

BinaryWatch::BinaryWatch() {
    for (auto h = 0; h < 12; h++) {
        for (auto m = 0; m < 60; m++) {
            auto b = bits(h, m);
            auto s = time(h, m);

            if (_cache.find(b) == _cache.end()) {
                vector<string> single{s};
                _cache[b] = single;
            } else {
                _cache[b].push_back(s);
            }
        }
    }
}

vector<string> BinaryWatch::get_n(int n) {
    return _cache[n];
}