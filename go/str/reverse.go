package str

func ReverseVowels(str string) string {
	bs := []byte(str)
	var i = 0
	var j = len(bs) - 1

	for i < j {
		for i < j {
			c := str[i]
			if c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' {
				break
			}
			i++
		}

		for i < j {
			c := str[j]
			if c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' {
				break
			}
			j--
		}

		if i < j {
			t := bs[i]
			bs[i] = bs[j]
			bs[j] = t
			i++
			j--
		}
	}

	return string(bs[:])
}

func ReverseWord(sentence string) string {
	bytes := []byte(sentence)
	bytes = reverse(bytes, 0, len(bytes))

	i := 0
	j := 0

	for i < len(bytes) && j < len(bytes) {
		if bytes[i] == ' ' {
			i++
		}
		j = i
		for j < len(bytes) && bytes[j] != ' ' {
			j++
		}
		bytes = reverse(bytes, i, j)
		i = j
	}

	if i != j {
		bytes = reverse(bytes, i, j)
	}

	return string(bytes[:])
}

func reverse(bytes []byte, s int, e int) []byte {
	half := (e - s) / 2
	for i := 0; i < half; i++ {
		c := bytes[s+i]
		bytes[s+i] = bytes[e-i-1]
		bytes[e-i-1] = c
	}

	return bytes
}
