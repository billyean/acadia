//
// Created by haibo on 3/16/18.
//

#ifndef ALGORITHM_FIBONACCI_H
#define ALGORITHM_FIBONACCI_H

#include <vector>
#include <map>

using namespace std;

class Fibonacci {
public:
    Fibonacci();

    long nth(int);
private:
    vector<vector<long>> times(vector<vector<long>> , vector<vector<long>>, int r);

    map<int, vector<vector<long>>> _twoFi;
};


#endif //ALGORITHM_FIBONACCI_H
