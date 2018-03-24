//
// Created by haibo on 3/24/18.
//

#ifndef ALGORITHM_MAGICDICTIONARY_H
#define ALGORITHM_MAGICDICTIONARY_H

#include <vector>
#include <string>

using namespace std;

class MagicDictionary {
public:
    MagicDictionary(){}
    void buildDict(vector<string>);

    bool search(string);
private:
    vector<string> dict_;

    int diff(string, string);
};


#endif //ALGORITHM_MAGICDICTIONARY_H
