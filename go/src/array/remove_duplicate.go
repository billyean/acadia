package array

func RemoveDup(nums []int) int {
	var nlen = 1

	if (len(nums) > 0) {
		for pos := 0; pos < len(nums) - 1; pos++ {
			c := nums[pos]
			for pos < len(nums) - 1 && nums[pos + 1] == c {
				pos++
			}

			if pos < len(nums) - 1 {
				nums[nlen] = c
				nlen++
			}
		}
	}
	return nlen
}

func RemoveDupAtMostTwice(nums []int) int {
	var nlen = 0

	cache := make(map[int]int)

	if (len(nums) > 0) {
		for pos := 0; pos < len(nums); pos++ {
			v := nums[pos]
			if cache[v] < 2 {
				cache[v]++
				nums[nlen] = v
				nlen++
			}
		}
	}
	return nlen
}
