# Here is the story
# https://www.linkedin.com/pulse/software-engineer-detained-several-hours-us-customs-given-fairchild

class Tree:
    def __init__(self, left, right, value):
        self._left = left
        self._right = right
        self._value = value

    def is_balanced(self):
        return self.recursive_is_balanced() >= 0

    def recursive_is_balanced(self):
        hf = 0
        hr = 0
        if self._left is not None:
            hf = self._left.recursive_is_balanced()

        if self._right is not None:
            hr = self._right.recursive_is_balanced()

        if hf == -1 or hr == -1 or abs(hf - hr) > 1:
            return -1

        return max(hf, hr) + 1

if __name__ == '__main__':
    # https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
    # Test1
    n12 = Tree(None, None, 12)
    n14 = Tree(n12, None, 14)
    n9 = Tree(None, n14, 9)
    n19 = Tree(None, None, 19)
    n23 = Tree(n19, None, 23)
    n17 = Tree(n9, n23, 17)
    n67 = Tree(None, None, 67)
    n72 = Tree(n67, None, 72)
    n54 = Tree(None, n72, 54)
    n76 = Tree(n54, None, 76)
    n50 = Tree(n17, n76, 50)
    print(n50.is_balanced())

    m9 = Tree(None, None, 9)
    m14 = Tree(None, None, 14)
    m12 = Tree(m9, m14, 12)
    m19 = Tree(None, None, 19)
    m23 = Tree(m19, None, 23)
    m17 = Tree(m12, m23, 17)
    m67 = Tree(None, None, 67)
    m54 = Tree(None, m67, 54)
    m76 = Tree(None, None, 76)
    m72 = Tree(m54, m76, 72)
    m50 = Tree(m17, m72, 50)
    print(m50.is_balanced())