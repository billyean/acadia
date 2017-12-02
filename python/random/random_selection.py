#!/usr/bin/env python3

import random

# Proof that this algorithm can't do perfect random

def random_select(list, n):
    rl = [0] * n
    l = len(list)
    for i in range(n):
        p = random.randrange(l - i)
        rl[i] = list[p]
        if (p != l - i - 1):
            list[p], list[l - i - 1] = list[l - i - 1], list[p]
    return rl

if __name__ == '__main__':
    list = [1,2,3,4,5]

    existed = []
    new = random_select(list, 3)
    count = 0
    while (new not in existed):
        existed.append(new)
        print(new)
        new = random_select(list, 3)
        count += 1
    print("After {} times to get duplication".format(count))