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

#ifndef ALGORITHM_PALINDROME_H
#define ALGORITHM_PALINDROME_H

#include "LinkedList.h"
#include <string>
#include <vector>

using namespace std;

class Palindrome {
public:
    static string nearestPalindromic(string);

    static bool valid(const string&);

    static bool palindrome_number1(int);

    static bool palindrome_number2(int);

    static bool isPalindrome(string);

    static int longestPalindrome(string);

    static vector<vector<int>> palindromePairs(vector<string>&);

    static int largestPalindrome(int);

    bool isPalindrome(LinkedListNode<int>*);
private:
    static bool palindrome(string, int, int);

    LinkedListNode<int>* left_;

    bool isPalindromeHelper(LinkedListNode<int>*);
};


#endif //ALGORITHM_PALINDROME_H
