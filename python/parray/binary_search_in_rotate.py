class BinarySearchInRotate:
    def search(self, l, v, s, e):
        if s < e:
            m = (s + e) // 2

            if l[m] == v:
                return m
            elif l[s] < l[m]:
                if e < l[s]:
                    self.search(l, v, m + 1, e)
                else:
                    self.search(l, v, m - 1, e)
            else:
                if e > l[e]:
                    self.search(l, v, m - 1, e)
                else:
                    self.search(l, v, m + 1, e)


