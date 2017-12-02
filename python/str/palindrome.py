class Palindrome:
    def is_palindrome(self, s):
        half = len(s) // 2
        return s[0:half] == s[:-(half+1):-1]

    def allPairs(self, words):
        pairs = []
        for i, iw in enumerate(words):
            for j, jw in enumerate(words):
                if i != j and self.is_palindrome(iw + jw):
                    pairs.append([i, j])

        return pairs