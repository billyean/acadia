package ll

import (
	"github.com/go/src/ll"
	"testing"
)

func TestCirculated(t *testing.T) {
	head := ll.ListFromSlice([]int{1, 2, 3, 4, 5})

	if ll.Circulated(head) {
		t.Errorf("This mylist is expected no-ciculated.")
	}
}

func TestNotCirculated(t *testing.T) {
	circulated := ll.CirculateListFromSlice([]int{1, 2, 3, 4, 5}, 2)

	if !ll.Circulated(circulated) {
		t.Errorf("This mylist is expected ciculated.")
	}
}

func TestNonCiculatedJunction(t *testing.T) {
	head := ll.ListFromSlice([]int{1, 2, 3, 4, 5})

	if ll.Junction(head) != nil {
		t.Errorf("no-ciculated mylist should not have junction.")
	}
}

func TestJunction(t *testing.T) {
	slice := []int{1, 2, 3, 4, 5}
	circulated := ll.CirculateListFromSlice(slice, 2)

	actual := ll.Junction(circulated).Value
	if actual != 2 {
		t.Errorf("Junction on this circulated mylist expects 2 but got %d.", actual)
	}
}
