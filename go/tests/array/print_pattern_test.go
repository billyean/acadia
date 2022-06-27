package array

import (
	"github.com/go/src/array"
	"reflect"
	"testing"
)

func TestPrintPattern0(t *testing.T) {
	actual := array.PrintPattern(0)
	if actual != nil {
		t.Errorf("PrintPattern(0) expects empty array but got %v.", actual)
	}
}

func TestPrintPattern1(t *testing.T) {
	actual := array.PrintPattern(1)
	if !reflect.DeepEqual(actual, [][]int{{1}}) {
		t.Errorf("PrintPattern(1) expects {{1}} array but got %v.", actual)
	}
}

func TestPrintPattern4(t *testing.T) {
	actual := array.PrintPattern(4)
	if !reflect.DeepEqual(actual, [][]int{{1}, {1, 1}, {2, 1}, {1, 2, 1, 1}}) {
		t.Errorf("PrintPattern(4) expects {{1}, {1, 1}, {2, 1}, {1, 2, 1, 1}} array but got %v.", actual)
	}
}

func TestPrintPattern8(t *testing.T) {
	actual := array.PrintPattern(8)
	if !reflect.DeepEqual(actual, [][]int{{1}, {1, 1}, {2, 1}, {1, 2, 1, 1}, {1, 1, 1, 2, 2, 1}, {3, 1, 2, 2, 1, 1}, {1, 3, 1, 1, 2, 2, 2, 1}, {1, 1, 1, 3, 2, 1, 3, 2, 1, 1}}) {
		t.Errorf("PrintPattern(8) expects {{1}, {1, 1}, {2, 1}, {1, 2, 1, 1}, {1, 1, 1, 2, 2, 1}, {3, 1, 2, 2, 1, 1}, {1, 3, 1, 1, 2, 2, 2, 1}, {1, 1, 1, 3, 2, 1, 3, 2, 1, 1}} array but got %v.", actual)
	}
}