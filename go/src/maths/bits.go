package maths

func PowerOfTwo(n int) bool {
	return n&(n-1) == 0
}

func PowerOfFour(n int) bool {
	return n == 1 || PowerOfTwo(n) && (n&0xaaaaaaaa == 0)
}

func SingleInTwos(nums []int) int {
	s := 0

	for _, v := range nums {
		s ^= v
	}

	return s
}

// [0 0 0] => [0 0 1] => [0 0]
// [1 0 0] => [1 0 1] => [1 0]
// [0 1 0] => [1 0 1] => [1 0]
// [1 1 0] => [0 1 1] => [0 1]
// [0 0 1] => [0 1 1] => [0 1]
// [1 0 1] => [1 1 0] => [0 0]
func SingleInThrees(nums []int) int {
	ones := 0
	twos := 0

	for _, v := range nums {
		twos |= ones & v
		ones ^= v
		threes := twos & ones
		ones &= (^threes)
		twos &= (^threes)
	}

	return ones
}

// [0 0 0 0] => [0 0 0 0] => [0 0 0]
// [1 0 0 0] => [1 0 0 0] => [1 0 0]
// [0 1 0 0] => [1 0 0 0] => [1 0 0]
// [1 1 0 0] => [0 1 0 0] => [0 1 0]
// [0 0 1 0] => [0 1 0 0] => [0 1 0]
// [1 0 1 0] => [1 1 1 0] => [0 0 1]
// [0 0 0 1] => [0 0 0 0] => [0 0 1]
// [1 0 0 1] => [1 1 1 1] => [0 0 0]
func SingleInFours(nums []int) int {
	ones := 0
	twos := 0
	threes := 0

	for _, v := range nums {
		twos |= ones & v
		ones ^= v
		threes = ones & twos
		fours := threes & ^ones
		ones &= ^fours
		twos &= ^fours
		threes &= ^fours
	}
	return ones
}
