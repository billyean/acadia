package maths

import "sort"

func Add(nums []int) []int {
	carrier := 1

	for i := len(nums) - 1; i >= 0; i-- {
		nums[i] += carrier
		carrier = nums[i] / 10
		nums[i] %= 10
	}

	if carrier == 1 {
		nums = append([]int{1}, nums...)
	}

	return nums
}

type ByNumber []int

func onesLess(p1, p2 int) bool {
	return ones(p1) < ones(p2)
}

func (s ByNumber) Len() int {
	return len(s)
}

func (s ByNumber) Swap(i, j int) {
	c := s[i]
	s[i] = s[j]
	s[j] = c
}

func (s ByNumber) Less(i, j int) bool {
	return ones(s[i]) < ones(s[j])
}

func Sort(nums []int) []int {
	sort.Sort(ByNumber(nums))
	return nums
}

func ones(n int) int {
	one := 0
	for n != 0 {
		n -= n & -n
		one++
	}
	return one
}
