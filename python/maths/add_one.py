class AddOne:
    def add_one(self, nums):
        c = 1

        for (i, v) in reversed(list(enumerate(nums))):
            n = v + c
            nums[i] = n % 10
            c = n // 10

        if c == 1:
            return [1] + nums
        else:
            return nums