def permutate(list):
    permutation = []

    permutation.append(list)

    while next(list):
        permutation.append(list[:])

    return permutation

def next(list):
    i = len(list) - 1

    while (True):
        j = i
        i -= 1

        if i == -1:
            reverse(list, 0, len(list))
            return False

        if list[i] < list[j]:
            k = len(list) - 1
            while (list[k] <= list[i]):
                k -= 1
            swap(list, i, k);
            reverse(list, j, len(list))
            return True


def reverse(list, s, e):
    if (s > 0):
        list[s:e] = list[e-1:s-1:-1]
    else:
        list[:e] = list[e-1::-1]

def swap(list, s, e):
    list[s], list[e] = list[e], list[s]

if __name__ == "__main__":
    p = permutate([1,2,2,4])
    print(p)



