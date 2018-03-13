package array

func Convert(s string, numRows int) string {
	if (numRows < 2 || len(s) == 0) {
		return s
	}

	zs := ""

	for i := 0; i < numRows; i++ {
		sp1 := 2 * (numRows - i - 1)
		sp2 := 2 * i

		index := i
		add := true

		for index < len(s) {
			zs += s[index:index + 1]

			switch {
			case sp1 == 0:
				index += sp2
			case sp2 == 0:
				index += sp1
			case add:
				index += sp1
			default:
				index += sp2
			}

			add = !add
		}

	}

	return zs
}
