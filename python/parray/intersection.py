class Intersection:
    def intersectNum(self, arrs):
        map = {}
        n = 0
        for l in arrs:
            for i in l:
                if i in map:
                    map[i].append(n)
                else:
                    map[i] = [n]
            n += 1

        intersect = 0
        for (k, v) in map.items():
            if len(v) == n:
                intersect += 1

        return intersect