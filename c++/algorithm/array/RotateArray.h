//
// Created by haibo on 3/19/18.
//

#ifndef ALGORITHM_ROTATEARRAY_H
#define ALGORITHM_ROTATEARRAY_H


class RotateArray {
public:
    static void rotateRight(int*, int, int);
    static void rotateLeft(int*, int, int);
private:
    static void reverse(int*, int, int);
    static void swap(int*, int, int);
};


#endif //ALGORITHM_ROTATEARRAY_H
