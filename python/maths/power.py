class Power:
    def powerOfTwo(self, n):
        return n & (n - 1) == 0

    def powerOfFour(self, n):
        return n & (n - 1) == 0 and (n & 0x55555555) == 0