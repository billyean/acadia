package str

func ReverseVowels(str string) string {
	bs := []byte(str)
	var i = 0
	var j = len(bs) - 1

	for i < j {
		for i < j {
			c := str[i]
			if c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' ||  c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' {
				break
			}
			i++
		}

		for i < j {
			c := str[j]
			if c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' ||  c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' {
				break
			}
			j--
		}

		if i != j {
			t := bs[i]
			bs[i] = bs[j]
			bs[j] = t

		}
	}

	return string(bs[:])
}
