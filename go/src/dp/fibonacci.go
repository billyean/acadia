package dp

// This is a better version of Fibonacci
func Fibonacci(num int) int {
	if num < 0 {
		return -1
	}

	if (num == 1 || num == 2) {
		return 1
	}

	var cache = make(map[int][2][2]int)

	var n = num - 1
	var s = 0
	for n != 0 {
		n >>= 1
		s += 1
	}

	cache[1] = [2][2]int {
		{1, 1},
		{1, 0},
	}

	var index = 1

	for i := 2; i <= s; i++ {
		nc := multiply(cache[index], cache[index])
		index <<= 1
		cache[index] = nc
	}
	n = num - 1

	var l = n & (-n)
	var mr = cache[l]
	n -= l

	for n > 0 {
		l = n & -n
		mr = multiply(mr, cache[l])
		n -= l
	}

	return mr[0][0]
}


// matrix multiply
func multiply(m1 [2][2]int, m2 [2][2]int) [2][2]int {
	r00 := m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]
	r01 := m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]
	r10 := m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]
	r11 := m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]

	return [2][2]int{
		{r00, r01},
		{r10, r11},
	}
}