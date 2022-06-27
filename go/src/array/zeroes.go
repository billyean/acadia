package array

func Move(nums []int) []int {
	last := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			if i != last {
				nums[last] = nums[i]
			}
			last++
		}
	}

	for i := last; i < len(nums); i++ {
		nums[i] = 0
	}

	return nums
}
