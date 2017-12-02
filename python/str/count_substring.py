#!/usr/bin/env python3

class SubString:
    def kmp_index(self, string):
        l = len(string)
        kmp_index = [0] * l
        kmp_index[0] = 0
        pos = 0

        for i in range(1, l):
            while (pos > 0 and string[pos] != string[i]):
                pos = kmp_index[pos - 1]
            if (string[pos] == string[i]):
                pos += 1
            kmp_index[i] = pos

        return kmp_index

    def count_substring(self, string, sub_string):
        n = 0
        lp = self.kmp_index(sub_string)

        k = 0
        for i, c in enumerate(string):
            if c == sub_string[k]:
                k += 1
            else:
                k = lp[k]
            if k == len(sub_string):
                n += 1
                k = lp[k - 1]
        return n







