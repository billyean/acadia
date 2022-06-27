package array


import (
	"github.com/go/array"
	"github.com/go/util"
	"reflect"
	"testing"
)

func TestMove1(t *testing.T) {
	test_data := []int{0}
	expected := []int{0}
	actual := array.Move(test_data)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("Move(%v) expects %s but got %s.", test_data, util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestMove2(t *testing.T) {
	test_data := []int{1}
	expected := []int{1}
	actual := array.Move(test_data)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("Move(%v) expects %s but got %s.", test_data, util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestMove3(t *testing.T) {
	test_data := []int{0, 0}
	expected := []int{0, 0}
	actual := array.Move(test_data)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("Move(%v) expects %s but got %s.", test_data, util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestMove4(t *testing.T) {
	test_data := []int{1, 2, 3}
	expected := []int{1, 2, 3}
	actual := array.Move(test_data)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("Move(%v) expects %s but got %s.", test_data, util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestMove5(t *testing.T) {
	test_data := []int{1, 0, 2, 0, 3, 0}
	expected := []int{1, 2, 3, 0, 0, 0}
	actual := array.Move(test_data)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("Move(%v) expects %s but got %s.", test_data, util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestMove6(t *testing.T) {
	test_data := []int{1, 0, 2, 0, 3, 0, 0}
	expected := []int{1, 2, 3, 0, 0, 0, 0}
	actual := array.Move(test_data)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("Move(%v) expects %s but got %s.", test_data, util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestMove7(t *testing.T) {
	test_data := []int{1, 0, 2, 0, 3, 4}
	expected := []int{1, 2, 3, 4, 0, 0}
	actual := array.Move(test_data)
	if  !reflect.DeepEqual(actual, expected) {
		t.Errorf("Move(%v) expects %s but got %s.", test_data, util.SliceToString1(expected), util.SliceToString1(actual))
	}
}
