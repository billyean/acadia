package miscellaneous

import "fmt"

func NWatch(num int) []string {
	i2t := make(map[int][]string)

	for h := 0; h < 12; h++ {
		for m := 0; m < 60; m++ {
			b := bits(h, m)
			s := time_str(h, m)
			if _, ok := i2t[b]; ok {
				i2t[b] = append(i2t[b], s)
			} else {
				i2t[b] = []string{s}
			}
		}
	}

	return i2t[num]
}

func bits(h int, m int) int {
	var b = 0

	for h > 0 {
		b += 1
		h -= h & -h
	}

	for m > 0 {
		b += 1
		m -= m & -m
	}

	return b
}

func time_str(h int, m int) string {
	return fmt.Sprintf("%d:%02d", h, m)
}
