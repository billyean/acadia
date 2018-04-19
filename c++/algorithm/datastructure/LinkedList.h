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
// Created by Haibo Yan on 4/4/18.
//

#ifndef ALGORITHM_LINKEDLIST_H
#define ALGORITHM_LINKEDLIST_H

#include <string>

using namespace std;

template <typename T> class LinkedListNode;

template <typename T> class LinkedList {
public:
    LinkedList(LinkedListNode<T>* head): head_(head){}

    bool circulated();

    string serialized();

    void removeKth(int);

    static LinkedList<T> serialized(string);
private:
    LinkedListNode<T>* head_;
};

template <typename T> class LinkedListNode {
public:
    friend class LinkedList<T>;

    friend class Palindrome;

    LinkedListNode(T& t, LinkedListNode<T>* next): t_(t), next_(next) {}

    LinkedListNode(T& t): t_(t), next_(NULL) {}
private:
    T& t_;

    LinkedListNode<T>* next_;
};


template <typename T>
bool LinkedList<T>::circulated() {
    if (head_ == NULL || head_->next_ == NULL) {
        return false;
    }

    auto o = head_;
    auto t = head_->next_;

    while (t != NULL && t->next_ != NULL) {
        if (o == t) {
            return true;
        }
        o = o->next_;
        t = t->next_->next_;
    }

    return false;
}

template <typename T>
void LinkedList<T>::removeKth(int k) {
    auto ak = head_;

    while (ak != NULL) {
        k--;
        ak = ak->next_;
    }

    if (k == 0) {

    }
}



#endif //ALGORITHM_LINKEDLIST_H
