class BinaryWatch:
    def __init__(self):
        self._cache = {}
        for h in range(12):
            for m in range(60):
                b = self.__bits__(h, m)
                t = self.__i_to_time__(h, m)
                if b in self._cache:
                    self._cache[b] += [t]
                else:
                    self._cache[b] = [t]

    def times(self, n):
        if n in self._cache:
            return self._cache[n]
        else:
            return []

    def __bits__(self, h, m):
        b = 0

        while h > 0:
            b += 1
            h -= h & -h

        while m > 0:
            b += 1
            m -= m & -m

        return b

    def __i_to_time__(self, h, m):
        return "{:d}:{:02d}".format(h, m)
