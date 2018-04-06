package util

import "strconv"

func SliceToString1(nums []int) string {
	if nums == nil {
		return "nil"
	}
	str := "["
	sep := ""
	for _, v := range nums {
		str += sep
		str += strconv.Itoa(v)
		sep = ","
	}
	str += "]"
	return str
}

func SliceToString2(nums [][]int) string {
	if nums == nil {
		return "nil"
	}
	str := "[ "
	sep := ""
	for _, v := range nums {
		str += sep
		str += SliceToString1(v)
		sep = ","
	}
	str += " ]"
	return str
}
