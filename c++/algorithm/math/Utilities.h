//
// Created by haibo on 3/16/18.
//

#ifndef ALGORITHM_UTILITIES_H
#define ALGORITHM_UTILITIES_H

#include <vector>
#include <string>

using namespace std;

class Utilities {
public:
    static vector<int> add_one(vector<int>&);

    static void sort_by_one_bits(vector<int>&);

    static int reverse(int);

    static vector<int> add(vector<int>&, vector<int>&);

    static int atoi(string);

    static bool ugly(int);

    static int nth_ugly(int);
private:
    static int bits(int);
};


#endif //ALGORITHM_UTILITIES_H
