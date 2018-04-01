//
// Created by Haibo Yan on 3/31/18.
//

// see https://github.com/billyean/algo_system_design/blob/master/amazon_1.png
// and https://github.com/billyean/algo_system_design/blob/master/amazon_2.png
#include "Amazon.h"

#include <map>
#include <regex>
#include <set>
#include <iostream>
#include <algorithm>

vector<string> Amazon::retrieveMostFrequentlyUsedWords(string literatureText, vector<string> wordsToExclude) {
    set<string> exclude;

    for (auto iw = wordsToExclude.begin(); iw != wordsToExclude.end(); iw++) {
        string w = (*iw);
        transform(w.begin(), w.end(), w.begin(), ::tolower);
        exclude.insert(w);x
    }

    map<string, int> words;
    regex r("([A-Za-z]+)");

    sregex_iterator next(literatureText.begin(), literatureText.end(), r), end;

    while (next != end) {
        string w = next->str();
        transform(w.begin(), w.end(), w.begin(), ::tolower);
        if (find(exclude.begin(), exclude.end(), w) == exclude.end()) {
            if (words.find(w) == words.end()) {
                words.insert({w, 1});
            } else {
                words[w]++;
            }
        }
        next++;
    }

    int top = 0;
    for (auto iw = words.begin(); iw != words.end(); iw++) {
        top = max(top, iw->second);
    }

    vector<string> mostFrequently;
    for (auto iw = words.begin(); iw != words.end(); iw++) {
        if (iw->second == top) {
            mostFrequently.push_back(iw->first);
        }
    }

    sort(mostFrequently.begin(), mostFrequently.end());

    return mostFrequently;
}

vector<string> Amazon::reorderLines(int logFileSize, vector<string> logLines) {
    vector<string> words, integers;

    cout << endl;
    for (auto line : logLines) {
        regex r("([a-zA-Z]+[0-9]+)( [0-9]+)(.*)");
        if (regex_match(line, r)) {
            integers.push_back(line);
        } else {
            words.push_back(line);
        }
    }

    sort(words.begin(), words.end(), [](string& s1, string& s2) {
        regex r("^([A-Za-z]+)([0-9]+) (.+)");
        smatch m1, m2;
        bool b1 = regex_search(s1, m1, r);
        bool b2 = regex_search(s2, m2, r);
        if (b1 && b2) {
            if (m1[3] == m2[3]) {
                auto identifier_str1 = m1[1];
                auto identifier_str2 = m2[1];
                auto i1 = stoi(m1[2]);
                auto i2 = stoi(m2[2]);
                if (i1 == i2) {
                    return identifier_str1 < identifier_str2;
                }
                return i1 < i2;
            } else {
                return m1[3] < m2[3];
            }
        } else {
            return false;
        }
    });

//    sort(integers.begin(), integers.end(), [](string& s1, string& s2) {
//        regex r("^([A-Za-z]+)([0-9]+)");
//        smatch m1, m2;
//        bool b1 = regex_search(s1, m1, r);
//        bool b2 = regex_search(s2, m2, r);
//        if (b1 && b2) {
//            auto identifier_str1 = m1[1];
//            auto identifier_str2 = m2[1];
//            auto i1 = stoi(m1[2]);
//            auto i2 = stoi(m2[2]);
//            cout << "i1 = " << i1 << "; i2 = " << i2 << endl;
//            if (i1 == i2) {
//                return identifier_str1 < identifier_str2;
//            }
//            return i1 < i2;
//        } else {
//            return false;
//        }
//    });

    words.insert(words.end(), integers.begin(), integers.end());
    return words;
}
