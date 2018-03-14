package miscellaneous

type vboundary struct {
	up int
	low int
	ru string
	rl string
}

func Int2Rome(num int) string {
	boundary := []vboundary{
		vboundary{1000, 900, "M", "C"},
		vboundary{ 500, 400, "D", "C"},
		vboundary{ 100,  90, "C", "X"},
		vboundary{  50,  40, "L", "X"},
		vboundary{  10,   9, "X", "I"},
		vboundary{   5,   4, "V", "I"},
		vboundary{   1,   1, "I", "I"},
	}

	var r string = ""

	for _, b := range boundary {
		for num >= b.low {
			if num < b.up {
				r += b.rl
			}
			r += b.ru
			num -= b.up
			if num < 0 {
				num += b.up - b.low
			}
		}
	}

	return r
}
