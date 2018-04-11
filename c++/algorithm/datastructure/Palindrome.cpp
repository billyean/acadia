//Copyright [2018] [Haibo Yan]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

//
// Created by haibo on 3/28/18.
//

#include "Palindrome.h"

#include <cctype>
#include <map>
#include <set>
#include <algorithm>
#include <numeric>
#include <iostream>

string Palindrome::nearestPalindromic(string n) {
    return "";
}

bool Palindrome::palindrome_number2(int n) {
    // Write your code here
    int i = n, r = 0;

    while (i != 0) {
        r <<= 1;
        r += i & 0x01;
        i >>= 1;
    }

    return r == n;
}

bool Palindrome::isPalindrome(string s) {
    int i = 0, j = s.size() - 1;

    while (i < j) {
        while (i < j && !isalpha(s[i]) ) {
            i++;
        }
        while (i < j && !isalpha(s[j]) ) {
            j--;
        }
        if (i < j) {
            char ci = s[i], cj = s[j];
            if (ci >= 'a') {
                ci = (char)('A' + (ci - 'a'));
            }
            if (cj >= 'a') {
                cj = (char)('A' + (cj - 'a'));
            }
            if (ci != cj) {
                return false;
            }
            i++;
            j--;
        }
    }

    return true;
}

// see https://leetcode.com/problems/longest-palindrome
// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can
// be built with those letters.
//
//This is case sensitive, for example "Aa" is not considered a palindrome here.
//
//Note:
//Assume the length of given string will not exceed 1,010.
int Palindrome::longestPalindrome(string s) {
    int nums[52];

    for (int i = 0; i < 52; i++) {
        nums[i] = 0;
    }

    for (int i = 0; i < s.size(); i++) {
        char c = s[i];
        int p = c > 'Z' ? c - 'a' + 26 : c - 'A';
        nums[p]++;
    }

    bool odd = false;
    int len = 0;
    for (int i = 0; i < 52; i++) {
        if ((nums[i] & 0x01) == 0) {
            len += nums[i];
        } else {
            len += nums[i] - 1;
            odd = true;
        }
    }
    if (odd) {
        len++;
    }

    return len;
}

// Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation
// of the two words, i.e. words[i] + words[j] is a palindrome.
//
// Example 1:
// Given words = ["bat", "tab", "cat"]
// Return [[0, 1], [1, 0]]
// The palindromes are ["battab", "tabbat"]
// Example 2:
// Given words = ["abcd", "dcba", "lls", "s", "sssll"]
// Return [[0, 1], [1, 0], [3, 2], [2, 4]]
// The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
vector<vector<int>> Palindrome::palindromePairs(vector<string>& words) {
    set<int> lens;
    vector<string> reversed;

    for (auto i = 0; i < words.size(); i++) {
        string r = words[i];
        string w = words[i];
        reverse(r.begin(), r.end());

        reversed.push_back(r);
        lens.insert(w.size());
    }

    map<string, vector<int>> end_with, start_with;

    for (auto i = 0; i < reversed.size(); i++) {
        string r = reversed[i];
        for (auto ilen = lens.begin(); ilen != lens.end(); ilen++) {
            if (r.size() >= *ilen) {
                string p = r.substr(0, *ilen);
                if (end_with.find(p) == end_with.end()) {
                    end_with[p] = {i};
                } else {
                    end_with[p].push_back(i);
                }
            }
        }
    }

    for (auto i = 0; i < words.size(); i++) {
        string w = words[i];
        for (auto ilen = lens.begin(); ilen != lens.end(); ilen++) {
            if (w.size() >= *ilen) {
                string p = w.substr(0, *ilen);
                reverse(p.begin(), p.end());
                if (start_with.find(p) == start_with.end()) {
                    start_with[p] = {i};
                } else {
                    start_with[p].push_back(i);
                }
            }
        }
    }

    vector<vector<int>> pairs;
    for (auto i = 0; i < words.size(); i++) {
        string wi = words[i];
        if (end_with.find(wi) != end_with.end()) {
            vector<int> ev = end_with[wi];
            for (auto iev = ev.begin(); iev != ev.end(); iev++) {
                auto j = *iev;
                string wj = words[j];
                if (i != j && palindrome(wj, 0, wj.size() - wi.size())) {
                    pairs.push_back({i, j});
                }
            }
        }

        if (start_with.find(wi) != start_with.end()) {
            vector<int> ev = start_with[wi];
            for (auto iev = ev.begin(); iev != ev.end(); iev++) {
                auto j = *iev;
                string wj = words[j];
                if (i != j && wi.size() != words[j].size() && palindrome(wj, wi.size(), wj.size() - wi.size())) {
                    pairs.push_back({j, i});
                }
            }
        }
    }

    sort(pairs.begin(), pairs.end(), [](vector<int> p1, vector<int> p2) -> bool {
       int s1 = accumulate(p1.begin(), p1.end(), 0);
       int s2 = accumulate(p2.begin(), p2.end(), 0);


       if (s1 != s2) {
           return s1 < s2;
       } else {
           return p1[0] < p2[0];
       }

    });

    return pairs;
}

bool Palindrome::palindrome(string str, int s, int l) {
    if (s > str.size()) {
        return false;
    }

    int h = l >> 1;
    for (int i = 0; i < h; i++) {
        if (str[s + i] != str[s + l -1 - i]) {
            return false;
        }
    }

    return true;
}