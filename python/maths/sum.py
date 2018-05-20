class Sum:
    def two_sum(self, list):
        pass

    def fourSum(self, nums, target):
        s = sorted(nums)
        return self.kSum(s, target, 4)


    def kSum(self, nums, target, k):
        r = []

        if k == 0 and target == 0:
            r.append([])
            return r

        if target > nums[-1] or k == 0 or len(nums) < k:
            return r

        c = nums[0]
        for d in self.kSum(nums[1:], target - c, k - 1):
            x = [c] + d
            r.append(x)

        for d in self.kSum(nums[1:], target, k):
            if d not in r:
                r.append(d)

        return r