package array

func MaxSlidingWindow(nums []int, k int) []int {
	var max []int
	if len(nums) == 0 {
		return max
	}

	var stack []int
	len := math.Min(len(nums), k)
	for i := 0; i < len; i++ {
		if len(stack) > 0 && i - stack[0] > k {
			stack = stack[1:]
		}
		v := nums[i]
		for len(stack) > 0 && nums[stack[len(stack) - 1]] < v  {
			stack =stack[0:len(stack) - 1]
		}
		stack = append(stack, i)
		max = append(max, nums[0])
	}

	return max
}