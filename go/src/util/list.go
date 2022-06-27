package util

import (
	"github.com/go/src/ll"
	"strconv"
)

func LLToString1(head *ll.LinkedList) string {
	c := head
	lstr := ""
	sep := ""

	for c != nil {
		lstr += sep
		lstr += strconv.Itoa(c.Value)
		c = c.Next
		sep = " -> "
	}

	return lstr
}

func LLToString2(head *ll.LinkedList, k int) string {
	c := head
	lstr := ""
	sep := ""
	i := 0

	for c != nil && i < k {
		lstr += sep
		lstr += strconv.Itoa(c.Value)
		c = c.Next
		sep = " -> "
		i++
	}

	return lstr
}
