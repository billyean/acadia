package util

func ToString1(nums []int) string {
	if nums == nil {
		return "nil"
	}
	str := "["
	sep := ""
	for _, v := range nums {
		str += sep
		str += string(v)
		sep = ","
	}
	str += "]"
	return str
}

func ToString2(nums [][]int) string {
	if nums == nil {
		return "nil"
	}
	str := "[ "
	sep := ""
	for _, v := range nums {
		str += sep
		str += ToString1(v)
		sep = ","
	}
	str += " ]"
	return str
}
