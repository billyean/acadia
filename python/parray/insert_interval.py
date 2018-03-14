class InsertInterval:
    def insert(self, l, i):
        sorted(l, key=lambda t: (t[1], t[0]))

        nl = []
        low = i[0]
        up = i[1]

        for interval in l:
            if interval[1] < i[0]:
                nl += [interval]
            elif interval[0] > i[1]:
                nl += [(low, up)]
                nl += [interval]
            else:
                low = min(interval[0], low)
                up = max(interval[1], up)

        if nl[-1][1] < low:
            nl += [(low, up)]

        return nl
