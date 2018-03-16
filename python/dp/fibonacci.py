import numpy as np

class Fibonnaci:
    def __init__(self):
        a = [[1, 1], [1, 0]]
        self._cache = {1:np.array(a)}
        k = 1
        for i in range(2, 8):
            n = self._cache[k].dot(self._cache[k])
            k *= 2
            print(k)
            self._cache[k] = n

    def nth(self, n):
        if n == 1 or n == 2:
            return 1
        n -= 1
        v = n & -n
        m = self._cache[v]
        n -= v

        while n != 0:
            v = n & -n
            m = m.dot(self._cache[v])
            n -= v

        return m[0][0]