//
// Created by haibo on 3/13/18.
//

#ifndef ALGORITHM_SLIDINGWINDOW_H
#define ALGORITHM_SLIDINGWINDOW_H

#include <vector>
#include <string>

using namespace std;

class SlidingWindow {
public:
    static vector<int> maxWindows(vector<int>&, int);

    static vector<double> median(vector<int>&, int);

    static string min_ordered(string, string);

    static string min_unordered(string, string);
};


#endif //ALGORITHM_SLIDINGWINDOW_H
