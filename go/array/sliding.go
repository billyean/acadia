package array

func MaxSlidingWindow(nums []int, k int) []int {
	var max = make([]int, 0)
	if len(nums) == 0 {
		return max
	}

	var stack []int

	for i := 0; i < len(nums); i++ {
		if len(stack) > 0 && i - stack[0] > k - 1 {
			stack = stack[1:]
		}
		v := nums[i]
		for len(stack) > 0 && nums[stack[len(stack) - 1]] < v  {
			stack =stack[0:len(stack) - 1]
		}
		stack = append(stack, i)
		if i >= k - 1 {
			max = append(max, nums[stack[0]])
		}
	}

	return max
}

func min(a int, b int) int{
	if a < b {
		return a
	} else {
		return b
	}
}