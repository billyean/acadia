package mylist

import (
	"container/list"
	"github.com/go/src/mylist"
	"testing"
)

func TestEmptyPalindrome(t *testing.T) {
	var p list.List

	if !mylist.IsSimplePalindrome(p) {
		t.Errorf("Empty list expected to be a palindrome.")
	}
}
