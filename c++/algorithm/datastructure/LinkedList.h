//
// Created by Haibo Yan on 4/4/18.
//

#ifndef ALGORITHM_LINKEDLIST_H
#define ALGORITHM_LINKEDLIST_H

#include <string>

using namespace std;

template <class T> class LinkedListNode {
public:
    LinkedListNode(T& t, LinkedListNode<T>* next): t_(t), next_(next) {}

    LinkedListNode(T& t): t_(t), next_(NULL) {}
private:
    T& t_;

    LinkedListNode<T>* next_;
};


template <class T> class LinkedList {
public:
    LinkedList(LinkedListNode<T>* head): head_(head){}

    bool circulated();

    string serialized();

    static LinkedList<T> serialized(string);
private:
    LinkedListNode<T>* head_;
};




#endif //ALGORITHM_LINKEDLIST_H
