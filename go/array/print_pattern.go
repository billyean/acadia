package array

func PrintPattern(n int) [][]int {
	var pattern [][]int

	if n == 0 {
		return pattern
	}
	pattern = append(pattern, []int{1})

	i := 0
	for i+1 < n {
		next := []int{}
		prev := pattern[i]
		for j := 0; j < len(prev); {
			n := j
			j++
			for j < len(prev) && prev[j] == prev[j-1] {
				j++
			}
			next = append(next, j-n)
			next = append(next, prev[n])
		}
		pattern = append(pattern, next)
		i++
	}

	return pattern
}
