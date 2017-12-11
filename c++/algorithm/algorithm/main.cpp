//
//  main.cpp
//  algorithm
//
//  Created by Yan, Tristan on 10/28/17.
//  Copyright © 2017 Yan, Tristan. All rights reserved.
//

#include <iostream>
#include "MedianFinder.h"

int main(int argc, const char * argv[]) {
//    // insert code here...
//    std::cout << "Hello, World!\n";

    MedianFinder mf;

    mf.addNum(1);
    mf.addNum(2);

    cout << "[1,2] Median is " << mf.findMedian() << endl;

    mf.addNum(3);

    cout << "Median is " << mf.findMedian() << endl;
    cout << "[1,2, 3] Median is " << mf.findMedian() << endl;

    return 0;
}
