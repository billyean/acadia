package mylist

import (
	"container/list"
)

func IsSimplePalindrome(l list.List) bool {
	prev := l.Front()
	next := l.Back()

	for prev != next && prev.Next() != next {
		if prev.Value != next.Value {
			return false
		}
		prev = prev.Next()
		next = next.Prev()
	}
	return true
}
