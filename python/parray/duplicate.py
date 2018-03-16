class Duplicate:
    def remove(self, nums):
        l = len(nums)
        if l < 2:
            return l

        p = 0
        for i in range(1, l):
            if nums[p] != nums[i]:
                p += 1
                nums[p] = nums[i]
        return p + 1

    def removeAtMostTwice(self, nums):
        map = {}

        l = len(nums)
        if l < 2:
            return l

        newLen = 1
        map[nums[0]] = 1

        for i in range(1, l):
            n = nums[i]
            if n not in map:
                nums[newLen] = nums[i]
                map[n] = 1
                newLen += 1
            elif map[n] == 1:
                nums[newLen] = nums[i]
                map[n] += 1
                newLen += 1

        return newLen