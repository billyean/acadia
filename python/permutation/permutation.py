#!/usr/bin/env python3

# permute a list. This algorithm accept duplicate elements.
# One example is [1, 2, 3, 4], you will get
# [1, 2, 3, 4]
# [1, 2, 3, 4]
# [1, 2, 4, 3]
# [1, 3, 2, 4]
# [1, 3, 4, 2]
# [1, 4, 2, 3]
# [1, 4, 3, 2]
# [2, 1, 3, 4]
# [2, 1, 4, 3]
# [2, 3, 1, 4]
# [2, 3, 4, 1]
# [2, 4, 1, 3]
# [2, 4, 3, 1]
# [3, 1, 2, 4]
# [3, 1, 4, 2]
# [3, 2, 1, 4]
# [3, 2, 4, 1]
# [3, 4, 1, 2]
# [3, 4, 2, 1]
# [4, 1, 2, 3]
# [4, 1, 3, 2]
# [4, 2, 1, 3]
# [4, 2, 3, 1]
# [4, 3, 1, 2]
# [4, 3, 2, 1]
# Another example is [2, 2, 1], you will get
# [1, 2, 2]
# [2, 1, 2]
# [2, 2, 1]
def permute(permute_list):
    permute_list.sort()
    permutation = []

    permutation.append(permute_list)

    while next(permute_list):
        permutation.append(permute_list[:])

    return permutation

# Iterator for decide next element. Key implementation of permutation algorithm.
# The algorithm is start from the last element. find the first element that is greater than its previous element. If no
# such a element found, return False and reverse the list back to original. If such a element found, set j as its index
# and set i as previous element index. Start from end again to look up first element is greater than element in index i
# and set its index as k, swap value in index i and k, reverse list from j to the end.
# The idea is start from the end, try to find element prior to an reversed order list. From the reversed list,
# find the element is greater than this element and swap them(note here is greater than, which prevents duplicate
# element swap to same value), then reverse the order list.
def next(permute_list):
    i = len(permute_list) - 1

    while (True):
        j = i
        i -= 1

        if i == -1:
            reverse(permute_list, 0, len(permute_list))
            return False

        if permute_list[i] < permute_list[j]:
            k = len(permute_list) - 1
            while (permute_list[k] <= permute_list[i]):
                k -= 1
            swap(permute_list, i, k);
            reverse(permute_list, j, len(permute_list))
            return True


# reverse a list by range(s,e)
def reverse(permute_list, s, e):
    if (s > 0):
        permute_list[s:e] = permute_list[e-1:s-1:-1]
    else:
        permute_list[:e] = permute_list[e-1::-1]

# swap the value in index s, e
def swap(permute_list, s, e):
    permute_list[s], permute_list[e] = permute_list[e], permute_list[s]

if __name__ == "__main__":
    p = permute([2, 1, 2, 4])
    p = permute([1, 2, 2])
    print(p)



