package array

import (
	"github.com/go/src/array"
	"reflect"
	"testing"
)

func TestSlidingWindows1(t *testing.T) {
	test_data := []int{1, 3, -1, -3, 5, 3, 6, 7}
	expected := []int{3, 3, 5, 5, 6, 7}
	actual := array.MaxSlidingWindow(test_data, 3)

	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("MaxSlidingWindow(%v, 3) expects %v but got %v.", test_data, expected, actual)
	}
}

func TestSlidingWindows2(t *testing.T) {
	test_data := []int{}
	expected := []int{}
	actual := array.MaxSlidingWindow(test_data, 0)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("MaxSlidingWindow(%v) expects %v but got %v.", test_data, expected, actual)
	}
}

func TestSlidingWindows3(t *testing.T) {
	test_data := []int{1, 3, 1, 2, 0, 5}
	expected := []int{3, 3, 2, 5}
	actual := array.MaxSlidingWindow(test_data, 3)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("MaxSlidingWindow(%v) expects %v but got %v.", test_data, expected, actual)
	}
}

func TestSlidingWindows4(t *testing.T) {
	test_data := []int{7, 2, 4}
	expected := []int{7, 4}
	actual := array.MaxSlidingWindow(test_data, 2)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("MaxSlidingWindow(%v) expects %v but got %v.", test_data, expected, actual)
	}
}

