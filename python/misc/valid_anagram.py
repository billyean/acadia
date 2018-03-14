class Anagram:
    def isAnagram(self, s, t):
        ms = {}
        mt = {}

        for c in s:
            if c in ms:
                ms[c] += 1
            else:
                ms[c] = 1

        for c in t:
            if c in mt:
                mt[c] += 1
            else:
                mt[c] = 1

        return ms == mt