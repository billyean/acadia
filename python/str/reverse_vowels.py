class ReverseVowels:
    def reverse(self, s):
        i = 0
        j = len(s) - 1

        while i < j:
            while i < j and s[i] not in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']:
                i += 1

            while i < j and s[j] not in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']:
                j -= 1

            if i != j:
                l = s[i]
                r = s[j]
                s = s[:i] + r + s[i+1:j] + l + s[j+1:]
                i += 1
                j -= 1

        return s