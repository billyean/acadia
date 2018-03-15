class MinStack:
    def __init__(self):
        self._stack = []

    def push(self, e):
        if len(self._stack) == 0:
            self._stack.append((e, e))
        else:
            m = min(self._stack[-1][1], e)
            self._stack.append((e, m))

    def pop(self):
        l = self._stack.pop(-1)
        return l[0]

    def top(self):
        return self._stack[-1][0]

    def empty(self):
        return len(self._stack) == 0

    def min(self):
        return self._stack[-1][1]