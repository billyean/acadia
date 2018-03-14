class Isomorphic:
    def strToDict(self, str):
        m = {}
        for c in str:
            if c in m:
                m[c] = m[c] + 1
            else:
                m[c] = 1
        return m

    def isomorphic(self, str1, str2):
        return self.strToDict(str1) == self.strToDict(str2)