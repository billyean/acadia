package number

import "math"

// We define the Perfect Number is a positive integer that is equal to the sum
// of all its positive divisors except itself.
// Now, given an integer n, write a function that returns true when it is a
// perfect number and false when it is not.
// Example:
// Input: 28
// Output: True
// Explanation: 28 = 1 + 2 + 4 + 7 + 14
func CheckPerfectNumber(num int) bool {
	if num == 1 {
		return false
	}
	var s = int(math.Sqrt(float64(num)))
	var sum = 1
	var index = 2
	for index <= s {
		if num%index == 0 {
			if index*index == num {
				sum += index
			} else {
				sum += index + num/index
			}

			if sum > num {
				return false
			}
		}

		index += 1
	}

	return sum == num
}
