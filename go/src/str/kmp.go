package str

func Substr(s string, p string) int {
	moves := next(p)

	var i = 0
	var j = 0

	for i < len(s) && j < len(p) {
		if s[i] == p[j] {
			i++
			j++
		} else if j > 0 {
			j = moves[j-1]
		} else {
			i++
		}
	}

	if j < len(p) {
		return -1
	} else {
		return i - j
	}
}

func next(cs string) []int {
	moves := make([]int, len(cs))

	moves[0] = 0

	var i = 0

	for j := 1; j < len(cs); j++ {
		for i > 0 && cs[i] != cs[j] {
			i = moves[i]
		}

		if cs[i] == cs[j] {
			i++
		}

		moves[j] = i
	}

	return moves
}
