package array

func BinarySearch(nums []int, k int) int {
	return binary_search(nums, k, 0, len(nums))
}

func binary_search(nums []int, k int, s int, e int) int {
	if s >= e {
		return -1
	}

	m := (s + e) >> 1

	if nums[m] == k {
		for m > 0 && nums[m - 1] == k {
			m--
		}
		return m
	} else if k < nums[m] {
		if nums[s] <= nums[m] {
			if k == nums[s] {
				return s
			} else if k > nums[s] {
				return binary_search(nums, k, s, m)
			} else {
				return binary_search(nums, k, m + 1, e)
			}
		} else {
			return binary_search(nums, k, s, m)
		}
	} else {
		if nums[e - 1] >= nums[m] {
			if k == nums[e - 1] {
				if (k == nums[s]) {
					return s
				} else {
					e--
					for e > 0 && nums[e - 1] == k {
						e--
					}
					return e
				}
			} else if k < nums[e - 1] {
				return binary_search(nums, k, m + 1, e)
			} else {
				return binary_search(nums, k, s, m)
			}
		} else {
			return binary_search(nums, k, m + 1, e)
		}
	}
}

func RotateLeft(nums []int, k int) {
	m := k % len(nums)

	reverse(nums, 0, m)
	reverse(nums, m, len(nums))
	reverse(nums, 0, len(nums))
}

func reverse(nums []int, s int, e int) {
	for s < e - 1 {
		v := nums[s]
		nums[s] = nums[e - 1]
		nums[e - 1] = v
		s++
		e--
	}
}

