//
// Created by Haibo Yan on 6/6/18.
//

#include "WaterPouring.h"
#include <iostream>
#include <stack>

void WaterPouring::printBar(vector<vector<char>>& bars) {
    int c = bars.size(), r = c > 0 ? bars[0].size() : 0;

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cout << bars[j][r - i - 1];
        }
        cout << endl;
    }
}

vector<vector<char>> WaterPouring::bars(vector<int>& bars) {
    auto max_it = max_element(bars.begin(), bars.end());
    int top = *max_it;

    vector<vector<char>> bars_v;
    for (int j = 0; j < bars.size(); j++) {
        vector<char> c(top + 1, ' ');
        for (int i = 0; i < bars[j] + 1; i++) {
            c[i] = '+';
        }
        bars_v.push_back(c);
    }

    return bars_v;
}

vector<vector<char>> WaterPouring::pouring(vector<int>& bars, vector<vector<char>>& container, int water, int position) {
    stack<int> left, right;

    int bl = bars[position], br = bars[position];

    int il = position - 1, ir = position + 1;

    while (il >= 0) {
        if (bars[il] > bl) {
            left.push(il);
        } else if (bars[il] < bl) {
            bl = bars[il];
        }
        il--;
    }

    while (ir < ) {
        if (bars[il] > bl) {
            left.push(il);
        } else if (bars[il] < bl) {
            bl = bars[il];
        }
        il--;
    }
}