class Rotate:
    def rotate_right(self, l, n):
        rn = n % len(l)
        if rn == 0:
            return l
        else:
            return l[-rn:] + l[:-rn]