class IntList:
    def __init__(self, v, n):
        self._v = v
        self._n = n

class Numbers:
    def add(self, l1, l2):
        if l1 == None:
            return l2

        if l2 == None:
            return l1

        c = 0
        c1 = l1
        c2 = l2
        s = sum(c1._v, c2._v, c)
        h = IntList(s(0), None)
        c = s(1)
        p = h
        c1 = c1._n
        c2 = c2._n

        while c1 != None or c2 != None:
            a1 = 0
            if c1 != None:
                a1 = c1._v
            a2 = 0
            if c2 != None:
                a2 = c2._v
            s = sum(a1, a2, c)
            c = s(1)
            n = IntList(s(0), None)
            p._n = n
            p = n
            if c1 != None:
                c1 = c1._n
            if c2 != None:
                c2 = c2._n


        return h

    def sum(self, a1, a2, c):
        s = a1 + a2 + c
        return (s % 10, s // 10)