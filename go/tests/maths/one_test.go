package maths

import (
	"github.com/go/src/maths"
	"github.com/go/src/util"
	"reflect"
	"testing"
)

func TestAddOne1(t *testing.T) {
	test_data := []int{1, 2, 3, 4, 5}
	expected := []int{1, 2, 3, 4, 6}
	actual :=  maths.Add(test_data)
	if !reflect.DeepEqual(expected, actual) {
		t.Errorf("Expected %s, but actual is %s.", util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestAddOne2(t *testing.T) {
	test_data := []int{1, 9, 9, 9}
	expected := []int{2, 0, 0, 0}
	actual :=  maths.Add(test_data)
	if !reflect.DeepEqual(expected, actual) {
		t.Errorf("Expected %s, but actual is %s.", util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestAddOne3(t *testing.T) {
	test_data := []int{9, 9, 9, 9}
	expected := []int{1, 0, 0, 0, 0}
	actual :=  maths.Add(test_data)
	if !reflect.DeepEqual(expected, actual) {
		t.Errorf("Expected %s, but actual is %s.", util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestSortByOnes1(t *testing.T) {
	test_data := []int{1, 2, 3, 4, 5}
	expected := []int{1, 2, 4, 3, 5}
	actual :=  maths.Sort(test_data)
	if !reflect.DeepEqual(expected, actual) {
		t.Errorf("Expected %s, but actual is %s.", util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestSortByOnes2(t *testing.T) {
	test_data := []int{1, -1, 2, -2, 3, -3}
	expected := []int{1, 2, 3, -2, -3, -1}
	actual :=  maths.Sort(test_data)
	if !reflect.DeepEqual(expected, actual) {
		t.Errorf("Expected %s, but actual is %s.", util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

func TestSortByOnes3(t *testing.T) {
	test_data := []int{}
	expected := []int{}
	actual :=  maths.Sort(test_data)
	if !reflect.DeepEqual(expected, actual) {
		t.Errorf("Expected %s, but actual is %s.", util.SliceToString1(expected), util.SliceToString1(actual))
	}
}

