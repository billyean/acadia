//
// Created by haibo on 3/28/18.
// see https://leetcode.com/problems/top-k-frequent-words
// Given a non-empty list of words, return the k most frequent elements.
// Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word
// with the lower alphabetical order comes first.
// Example 1:
// Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// Output: ["i", "love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:
// Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
// Output: ["the", "is", "sunny", "day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
// with the number of occurrence being 4, 3, 2 and 1 respectively.
// Note:
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Input words contain only lowercase letters.
// Follow up:
// Try to solve it in O(n log k) time and O(n) extra space.
#include "TopKFrequentWords.h"
#include <map>
#include <algorithm>

vector<string> TopKFrequentWords::topKFrequent(vector<string>& words, int k) {
    map<string, int> word_num;

    for (auto iw = words.begin(); iw != words.end(); iw++) {
        string word = *iw;
        if (word_num.find(word) == word_num.end()) {
            word_num.insert({word, 1});
        } else {
            word_num[word] += 1;
        }
    }

    vector<pair<string, int>> temp;
    for (auto imap = word_num.begin(); imap != word_num.end(); imap++) {
        temp.push_back(*imap);
    }

    sort(temp.begin(), temp.end(), [](pair<string, int> p1, pair<string, int> p2){
        if (p1.second == p2.second) {
            return p1.first < p2.first;
        } else {
            return p1.second > p2.second;
        }
    });

    vector<string> topK;

    int index = 0;
    for (auto im = temp.begin(); im != temp.end() && index < k; im++, index++) {
        string word = im->first;
        topK.push_back(word);
    }

    return topK;
}