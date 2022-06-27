package array

import (
	"github.com/go/src/array"
	"testing"
)

func TestRemoveDup(t *testing.T) {
	test_data := []int{1 , 1, 1, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5}
	actual := array.RemoveDup(test_data)
	if actual != 5 {
		t.Errorf("Remove duplicate from [1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5] expected 5 but got %d.", actual)
	}
}

func TestRemoveDupAtMostTwice(t *testing.T) {
	test_data := []int{1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5}
	actual := array.RemoveDupAtMostTwice(test_data)
	if actual != 8 {
		t.Errorf("Remove duplicate from [1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5] expected 8 but got %d.", actual)
	}
}
