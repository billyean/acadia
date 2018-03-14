class SortInt:
    def ones_quick(self, num):
        num_ones = 0

        while num != 0:
            num_ones += 1
            num -= num & -num

        return num_ones

    def ones_slow(self, num):
        num_ones = 0

        while num != 0:
            if (num & 1) == 1:
                num_ones += 1
            num >>= 1

        return num_ones