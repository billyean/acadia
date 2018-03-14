package miscellaneous

import "reflect"

func Valid(s string, t string) bool {
	ms := make(map[int32]int)
	mt := make(map[int32]int)

	for _, c := range s {
		ms[c] += 1
	}

	for _, c := range t {
		mt[c] += 1
	}

	return reflect.DeepEqual(ms, mt)
}
