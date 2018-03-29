class SingleNumber:
    def find_in_twos(self, nums):
        s = 0
        for i in nums:
            s ^= i
        return s

    # [0 0 0] => [0 0]
    # [1 0 0] => [1 0]
    # [0 1 0] => [1 0]
    # [1 1 0] => [0 1]
    # [0 1 1] => [0 0]
    def find_in_threes(self, nums):
        one = 0
        two = 0

        for i in nums:
            two |= one & i
            one ^= i
            three = one & two
            one &= ~three
            two &= ~three

        return one

    # [0 0 0 0] => [0 0 0]
    # [1 0 0 0] => [1 0 0]
    # [0 1 0 0] => [1 0 0]
    # [1 1 0 0] => [0 1 0]
    # [0 0 1 0] => [0 1 0]
    # [1 0 1 0] => [0 0 1]
    # [0 0 0 1] => [0 0 1]
    # [1 0 0 1] => [0 0 0]
    def find_in_fours(self, nums):
        one = 0
        two = 0

        for i in nums:
            two |= one & i
            one ^= i
            three = one & two
            four =  three & ~one
            one &= ~four
            two &= ~four
            three &= four

        return one